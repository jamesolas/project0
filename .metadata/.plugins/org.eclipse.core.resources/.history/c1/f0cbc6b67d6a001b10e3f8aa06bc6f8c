package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;
import com.app.model.Offer;

public interface EmployeeService {
	
	public List<Car> viewCars() throws BusinessException;
	public Car addCar(String make, String model) throws BusinessException;
	public void removeCar(int carId) throws BusinessException;
	public List<Offer> viewOffers() throws BusinessException;
	public int acceptOffer(int offerId) throws BusinessException;
	public void rejectOffer(int offerId) throws BusinessException;
	public List<Loan> viewPayments() throws BusinessException;
	
}
