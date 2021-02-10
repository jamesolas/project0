package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dbutil.ConnectionClosers;
import com.app.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;
import com.app.model.Offer;
import com.app.model.Payment;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public List<Car> viewCars() throws BusinessException {
		List<Car> carList = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select carid, make, model, status from project0.car where status = 'open'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car = new Car();
				car.setCarId(resultSet.getInt("carid"));
				car.setMake(resultSet.getString("make"));
				car.setModel(resultSet.getString("model"));
				car.setStatus(resultSet.getString("status"));
				carList.add(car);
			}
			if(carList.size() == 0) {
				throw new BusinessException("No open cars");
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carList;
	}

	@Override
	public int addCar(Car car) throws BusinessException {
		int a = 0;	
		try {
		Connection connection = PostgresqlConnection.getConnection();
		String sql = "insert into project0.car (make, model, status) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, car.getMake());
		preparedStatement.setString(2, car.getModel());
		preparedStatement.setString(3, "open");
		a = preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		} 
		
		return a;
	}

	@Override
	public int removeCar(int carId) throws BusinessException {
		int a = 0;
		try {
		Connection connection = PostgresqlConnection.getConnection();
		String sql = "delete from project0.car where carid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, carId);
		a = preparedStatement.executeUpdate();
		
		if(a != 0) {
			System.out.println("Car "+carId+" deleted");
		}
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		} 
		
		return a;
	}

	@Override
	public List<Offer> viewOffers() throws BusinessException {
		List<Offer> offerList = new ArrayList<>();
		Connection connection = null;
		
		try{
			connection = PostgresqlConnection.getConnection();
			String sql = "select offerid, userid, firstname, lastname, carid, make, model, amount from project0.offer";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Offer offer = new Offer();
				offer.setOfferId(resultSet.getInt("offerid"));
				offer.setUserId(resultSet.getInt("userid"));
				offer.setFirstName(resultSet.getString("firstname"));
				offer.setLastName(resultSet.getString("lastname"));
				offer.setCarId(resultSet.getInt("carid"));
				offer.setMake(resultSet.getString("make"));
				offer.setModel(resultSet.getString("model"));
				offer.setAmount(resultSet.getDouble("amount"));
				offerList.add(offer);
			}
			if(offerList.size() == 0) {
				throw new BusinessException("No offers");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.close(connection);
		}
		
		return offerList;
	}

	@Override
	public int acceptOffer(int offerId) throws BusinessException {
		int a = 0;
		int b = 0;
		int c = 0;
		
		Connection connection = null;
		
		try {
		connection = PostgresqlConnection.getConnection();
		String sql = "update project0.car set userid = offer.userid, status = 'sold' from project0.offer where car.carid = offer.carid and offerid = ?;";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, offerId);
		a = preparedStatement.executeUpdate();
		
		if(a != 0) {
		Connection connection2 = PostgresqlConnection.getConnection();
		String sql2 = "INSERT INTO project0.loan (purchaseprice, principal, interest, userid, carid, payments_remaining, payment_amount) "
				+ "SELECT amount, amount * .05, userid, carid, 60, round(amount + (amount * .05) / 60, 2) "
				+ "FROM project0.offer "
				+ "where offerid = ?;";
		PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
		preparedStatement2.setInt(1, offerId);
		b = preparedStatement2.executeUpdate();	
		}
		
		if(b != 0) {
			Connection connection3 = PostgresqlConnection.getConnection();
			//String sql3 = "delete from project0.offer where offerid = ?;";
			String sql3 = "delete from project0.offer using (select carid from project0.offer where offerid = ?) as find;";
			PreparedStatement preparedStatement3 = connection3.prepareStatement(sql3);
			preparedStatement3.setInt(1, offerId);
			c = preparedStatement3.executeUpdate();	
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		} finally {
			ConnectionClosers.close(connection);
		}
		
		return c;
	}

	@Override
	public int rejectOffer(int offerId) throws BusinessException {
		int a = 0;
		try {
		Connection connection = PostgresqlConnection.getConnection();
		String sql = "delete from project0.offer where offerid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, offerId);
		a = preparedStatement.executeUpdate();
		
		if(a != 0) {
			System.out.println("Offer "+offerId+" deleted");
		}
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		} 
		
		return a;
	}

	@Override
	public List<Loan> viewPayments() throws BusinessException {
		List<Loan> loanList = new ArrayList<>();
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "SELECT loanid, purchaseprice, interest, loan.userid, loan.carid, payments_remaining, payment_amount, car.carid, car.make, car.model\r\n"
					+ "FROM project0.loan INNER JOIN project0.car ON loan.carid = car.carid;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
				Loan loan = new Loan();
				loan.setLoanId(resultSet.getInt("loanId"));
				loan.setPurchasePrice(resultSet.getFloat("purchaseprice"));
				loan.setInterest(resultSet.getFloat("interest"));
				loan.setUserId(resultSet.getInt("userid"));
				loan.setCarId(resultSet.getInt("carid"));
				loan.setPaymentsRemaining(resultSet.getInt("payments_remaining"));
				loan.setPaymentAmount(resultSet.getFloat("payment_amount"));
				loanList.add(loan);
				}
				
			if(loanList.size() == 0) {
				throw new BusinessException("No loans on cars");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return loanList;
	}

	@Override
	public int addPayments(int offerId) throws BusinessException {
		int a = 0;	
		try {
		Connection connection = PostgresqlConnection.getConnection();
		String sql = "insert into project0.offer (make, model, status) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, offerId);
		a = preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		} 
		
		return a;
			
		}
	

}
