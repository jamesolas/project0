package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Payment;

public interface CustomerService {
	public List<Car> viewOpenCars() throws BusinessException;
	public int makeOffer(int userId, int carId, float amount) throws BusinessException;
	public List<Car> viewOwnedCars(int userId) throws BusinessException;
	public List<Payment> viewRemainingPayments(int userId) throws BusinessException;
	public int makePayment(int userId, int loanId);

}
