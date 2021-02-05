package com.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Offer;
import com.app.model.Payment;
import com.app.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO dao = new EmployeeDAOImpl();
	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);


	@Override
	public List<Car> viewCars() throws BusinessException {
		List<Car> carList = null;
		
		//code to DAO
		carList = dao.viewCars();
		
		//return car object
		return carList;
	}

	@Override
	public Car addCar(String make, String model) throws BusinessException {
		//code to DAO
		Car car = new Car(make, model);
		if(dao.addCar(car) != 0) {
			log.info("Car added");
		}
		return car;
	}

	@Override
	public void removeCar(int carId) throws BusinessException {
		//code to DAO
		dao.removeCar(carId);
		
	}

	@Override
	public List<Offer> viewOffers() throws BusinessException {
		List<Offer> offerList = null;
		//code to DAO
		offerList = dao.viewOffers();
		return offerList;
	}

	@Override
	public int acceptOffer(int offerId) throws BusinessException {
		//code to DAO
		dao.acceptOffer(offerId);
		
		return 0;
	}

	@Override
	public void rejectOffer(int offerId) throws BusinessException {
		//code to DAO
		dao.rejectOffer(offerId);
	}

	@Override
	public List<Payment> viewPayments() throws BusinessException {
		List<Payment> paymentList = null;
		//code to DAO
		paymentList = dao.viewPayments();
		return paymentList;
	}

}
