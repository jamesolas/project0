package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.app.dao.CustomerDAO;
import com.app.dbutil.ConnectionClosers;
import com.app.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;
import com.app.model.Payment;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public List<Car> viewOpenCars() throws BusinessException {
		List<Car> carList = new ArrayList<>();
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "Select carid, make, model, status from project0.car where status = 'open'";
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
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return carList;
	}

	@Override
	public int makeOffer(int userId, int carId, float amount) throws BusinessException {
		int a = 0;	
		try {
		Connection connection = PostgresqlConnection.getConnection();
		String sql = "insert into project0.offer (userid, carid, amount) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, carId);
		preparedStatement.setFloat(3, amount);
		a = preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		} 
		
		return a;
	}

	@Override
	public List<Car> viewOwnedCars(int userId) throws BusinessException {
		List<Car> carList = new ArrayList<>();
		Connection connection = null;
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "Select carid, make, model,status, userid from project0.car where userid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car = new Car();
				car.setCarId(resultSet.getInt("carid"));
				car.setMake(resultSet.getString("make"));
				car.setModel(resultSet.getString("model"));
				car.setStatus(resultSet.getString("status"));
				car.setUserId(resultSet.getInt("userid"));
				carList.add(car);
			}if(carList.size() == 0) {
				throw new BusinessException("No owned cars");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.close(connection);
		}
		return carList;
	}

	@Override
	public List<Loan> viewRemainingPayments(int userId) throws BusinessException {
		List<Loan> loanList = new ArrayList<>();
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "SELECT loanid, purchaseprice, interest, loan.userid, loan.carid, payments_remaining, payment_amount, car.carid, car.make, car.model\r\n"
					+ "FROM project0.loan INNER JOIN project0.car ON loan.carid = car.carid WHERE loan.userid = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
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
				throw new BusinessException("No owned cars");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return loanList;
	}

	@Override
	public int makePayment(int userId, int carId) throws BusinessException {
		int a = 0;
		try {
		Connection connection = PostgresqlConnection.getConnection();
		String sql = "update project0.loan set payments_remaining = payments_remaining - 1 where userid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		a = preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		} 
		
		return a;
	}

}
