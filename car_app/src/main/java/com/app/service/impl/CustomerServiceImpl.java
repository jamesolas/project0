package com.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;
import com.app.model.Payment;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	private static Logger log = Logger.getLogger(CustomerServiceImpl.class);
	
	CustomerDAO dao = new CustomerDAOImpl();
	

	@Override
	public List<Car> viewOpenCars() throws BusinessException {
		List<Car> carList = null;
		//code to DAO
		carList = dao.viewOpenCars();
		return carList;
	}

	@Override
	public int makeOffer(int userId, int carId, float amount) throws BusinessException {
		int a = 0;
		if(dao.makeOffer(userId, carId, amount) != 0){
			System.out.println("Offer was made");
		}
		return a;
	}

	@Override
	public List<Car> viewOwnedCars(int userId) throws BusinessException {
		List<Car> carList = null;
		carList = dao.viewOwnedCars(userId);
		return carList;
	}

	@Override
	public List<Loan> viewRemainingPayments(int userId) throws BusinessException {
		List<Loan> loanList = null;
		loanList = dao.viewRemainingPayments(userId);
		return loanList;
	}

	@Override
	public int makePayment(int userId, int carId) {
		int makePayment = 0;
		try {
			makePayment = dao.makePayment(userId, carId);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if(makePayment != 0) {
			System.out.println("Payment made");
		}
		return makePayment;
	}

}
