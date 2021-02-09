package com.app.service.impl;

import org.apache.log4j.Logger;

import com.app.dao.impl.UserDAOImpl;
import com.app.exception.BusinessException;
import com.app.main.Main;
import com.app.model.User;
import com.app.service.UserService;

public class UserServiceImpl implements UserService {
	
	private static Logger log = Logger.getLogger(Main.class);
	
	UserDAOImpl dao = new UserDAOImpl();

	@Override
	public User createAccount(String firstName, String lastName, String email, String password) throws BusinessException {
		
		User user = new User(firstName, lastName, email, password);
		
		if(dao.createAccount(user) != 0) {
			log.info("Customer created successfully.");
		}
				
		return user;
	}

	@Override
	public User logIn(String email, String password) throws BusinessException {
		User user = null;
		if(email.length() > 0 && password.length() > 0) {
			//code here for DAO
			user = dao.logIn(email, password);
		
		}else {
			throw new BusinessException ("Entered email and password are invalid.");
		}
		return user;
	}

	@Override
	public int findUserId(String email) throws BusinessException {
		int userId = 0;
		if(email.length() > 0) {
			userId = dao.findUserId(email);
		}else {
			log.info("Invalid email");
		}
		return userId;
	}

	@Override
	public String findType(String email) throws BusinessException {
		String type = null;
		if(email.length() > 0) {
			type = dao.findUserType(email);
		}else {
			log.info("Invalid email");
		}
		return type;
	}

	

}
