package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.app.dao.impl.UserDAOImpl;
import com.app.exception.BusinessException;
import com.app.main.Main;
import com.app.model.User;

public class UserServiceImplTest {
	
	private static Logger log = Logger.getLogger(Main.class);
	
	@InjectMocks
	private static UserServiceImpl userServiceImpl;
	
	@Mock
	private static UserDAOImpl userDAOImpl;

	@BeforeAll
	public static void setUpBeforeClass() {
		userServiceImpl = new UserServiceImpl();
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateAccount() {
	
		String firstName = "testFirst";
		String lastName = "testLast";
		String email = "testEmail";
		String password = "testPassword";
		
		User user = new User(firstName, lastName, email, password);
		
		try {
			Mockito.when(userDAOImpl.createAccount(user)).thenReturn(1);
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
		
		try {
			assertEquals(user, userServiceImpl.createAccount(firstName, lastName, email, password));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testLogIn() {
		String email = "james@gmail.com";
		String password = "pass";
		String type = "customer";
		User user = new User(email, password, type);
		
		
				try {
					Mockito.when(userServiceImpl.logIn(email, password)).thenReturn(user);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		
		try {
			assertEquals(user, userServiceImpl.logIn(email, password));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	void testFindUserId(){
		String email = "james@gmail.com";
		try {
			Mockito.when(userDAOImpl.findUserId(email)).thenReturn(2);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			assertEquals(2, userServiceImpl.findUserId(email));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	
	
}
