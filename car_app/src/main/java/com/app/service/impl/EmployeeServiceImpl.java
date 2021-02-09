package com.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;
import com.app.model.Offer;
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
	public int removeCar(int carId) throws BusinessException {
		int remove;
		//code to DAO
		remove = dao.removeCar(carId);
		if(remove != 0) {
			System.out.println("Car removed");
		};
		return remove;
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
		int offer = 0;
		//code to DAO
		offer = dao.acceptOffer(offerId);
		if(offer != 0) {
			System.out.println("Offer accepted");
		}
		
		return offer;
	}

	@Override
	public int rejectOffer(int offerId) throws BusinessException {
		int reject = 0;
		//code to DAO
		reject = dao.rejectOffer(offerId);
		if(reject != 0) {
			System.out.println("Offer rejected");
		}
		return reject;
	}

	@Override
	public List<Loan> viewPayments() throws BusinessException {
		List<Loan> paymentList = null;
		//code to DAO
		paymentList = dao.viewPayments();
		return paymentList;
	}

}
