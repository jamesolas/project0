package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;
import com.app.model.Offer;
import com.app.model.Payment;

public interface EmployeeDAO {
	
	public List<Car> viewCars() throws BusinessException;
	public int addCar(Car car) throws BusinessException;
	public int removeCar(int carId) throws BusinessException;
	public List<Offer> viewOffers() throws BusinessException;
	public int acceptOffer(int offerId) throws BusinessException;
	public int rejectOffer(int offerId) throws BusinessException;
	public List<Loan> viewPayments() throws BusinessException;
	public int addPayments(int offerId) throws BusinessException;
	
}
