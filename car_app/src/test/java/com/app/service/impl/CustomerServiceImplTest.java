package com.app.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Loan;

class CustomerServiceImplTest {
	
	@InjectMocks
	private static CustomerServiceImpl customerServiceImpl;
	
	@Mock
	private static CustomerDAOImpl customerDAOImpl;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerServiceImpl = new CustomerServiceImpl();
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testViewOpenCars() {
		List<Car> carList = new ArrayList<>();
			new Car(10, "Toyota", "Prius", "Open", 2);
			new Car(11, "BMW", "i5", "Open", 3);
			new Car(12, "Mercedes", "CLK", "Open", 4);
			
		try {
			Mockito.when(customerDAOImpl.viewOpenCars()).thenReturn(carList);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
			try {
				assertEquals(carList, customerServiceImpl.viewOpenCars());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

	@Test
	void testMakeOffer() {
		int userId = 2;
		int carId = 2;
		float amount = 500.43f;
		
		try {
			Mockito.when(customerDAOImpl.makeOffer(userId, carId, amount)).thenReturn(1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(1,customerServiceImpl.makeOffer(userId, carId, amount));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	void testViewOwnedCars() {
		List<Car> carList = new ArrayList<>();
		int carId = 10;
		String make = "Toyota";
		String model = "Highlander";
		String status = "open";
		int userId = 2;
		new Car(carId, make, model, status, userId);
		
		try {
			Mockito.when(customerDAOImpl.viewOwnedCars(userId)).thenReturn(carList);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(carList, customerServiceImpl.viewOwnedCars(userId));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	void testViewRemainingPayments() {
		
		int loanId = 1;
		float purchasePrice = 567.89f;
		float interest = purchasePrice * .05f;
		int userId = 2;
		int carId = 10;
		int paymentsRemaining = 50;
		float paymentAmount = purchasePrice * 12 * 5f;
		List<Loan> loanList = new ArrayList<>();
		Loan loan = new Loan(loanId, purchasePrice, interest, userId, carId, paymentsRemaining, paymentAmount);
		
		try {
			Mockito.when(customerDAOImpl.viewRemainingPayments(userId)).thenReturn(loanList);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(loanList, customerServiceImpl.viewRemainingPayments(userId));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testMakePayment() {
		int userId = 2;
		int carId = 1;
		
		try {
			Mockito.when(customerDAOImpl.makePayment(userId, carId)).thenReturn(1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(1, customerServiceImpl.makePayment(userId, carId));
		
	}

}
