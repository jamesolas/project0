package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.EmployeeDAO;
import com.app.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Offer;
import com.app.model.Payment;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Car> viewCars() throws BusinessException {
		List<Car> carList = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select carid, make, model, status from project0.car where status = 'open'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car = new Car();
				car.setCarid(resultSet.getInt("carid"));
				car.setMake(resultSet.getString("make"));
				car.setModel(resultSet.getString("model"));
				car.setStatus(resultSet.getString("status"));
				carList.add(car);
			}
			if(carList.size() == 0) {
				throw new BusinessException("No open cars");
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carList;
	}

	@Override
	public int addCar(String make, String model) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCar(int carId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Offer> viewOffers() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int acceptOffer(int offerId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rejectOffer(int offerId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Payment> viewPayments() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
