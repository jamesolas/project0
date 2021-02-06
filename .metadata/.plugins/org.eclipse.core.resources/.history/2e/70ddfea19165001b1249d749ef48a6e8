package com.app.service.impl;

import java.util.List;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Offer;
import com.app.model.Payment;
import com.app.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO dao = new EmployeeDAOImpl();

	@Override
	public List<Car> viewCars() throws BusinessException {
		List<Car> car = null;
		
		//code to DAO
		car = dao.viewCars();
		
		//return car object
		return car;
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
