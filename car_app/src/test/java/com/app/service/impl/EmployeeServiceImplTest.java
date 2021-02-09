package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Car;
import com.app.model.Offer;

class EmployeeServiceImplTest {
	
	@InjectMocks
	private static EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	private static EmployeeDAOImpl employeeDAOImpl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		employeeServiceImpl = new EmployeeServiceImpl();
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testViewCars() {
		List<Car> carList = new ArrayList<>();
		new Car(1, "Toyota", "Corolla", "open", 1);
		new Car(2, "Toyota", "Corolla", "open", 1);
		new Car(3, "Toyota", "Corolla", "open", 1);
		
		try {
			Mockito.when(employeeDAOImpl.viewCars()).thenReturn(carList);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(carList, employeeServiceImpl.viewCars());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAddCar() {
		String make = "Nissan";
		String model = "Sentra";
		Car car = new Car(make, model);
		
		try {
			Mockito.when(employeeDAOImpl.addCar(car)).thenReturn(1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(car, employeeServiceImpl.addCar(make, model));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Test
	void testRemoveCar() {
		int carId = 5;
		
		try {
			Mockito.when(employeeDAOImpl.removeCar(carId)).thenReturn(1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(1, employeeServiceImpl.removeCar(carId));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testViewOffers() {
		//these parameters are only here for reference
//		int offerId;
//		int userId;
//		String firstName;
//		String lastName;
//		int carId;
//		String make;
//		String model;
//		double amount;
		List<Offer> offerList = new ArrayList<>();
		new Offer(1, 2, "Name1", "Name1", 3, "Toyota", "Corolla", 458.48f);
		new Offer(2, 3, "Name2", "Name2", 3, "Toyota", "Corolla", 584.28f);
		new Offer(3, 4, "Name3", "Name3", 3, "Toyota", "Corolla", 583.22f);
		
		try {
			Mockito.when(employeeDAOImpl.viewOffers()).thenReturn(offerList);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(offerList, employeeServiceImpl.viewOffers());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testAcceptOffer() {
		fail("Not yet implemented");
	}


	//@Test
	void testRejectOffer() {
		fail("Not yet implemented");
	}


	//@Test
	void testViewPayments() {
		fail("Not yet implemented");
	}

}
