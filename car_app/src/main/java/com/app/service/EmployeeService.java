package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Offer;
import com.app.model.Payment;

public interface EmployeeService {
	
	public List<Car> viewCars() throws BusinessException;
	public int addCar(String make, String model) throws BusinessException;
	public int removeCar(int carId) throws BusinessException;
	public List<Offer> viewOffers() throws BusinessException;
	public int acceptOffer(int offerId) throws BusinessException;
	public int rejectOffer(int offerId) throws BusinessException;
	public List<Payment> viewPayments() throws BusinessException;

}
