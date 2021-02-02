package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.User;

public interface UserDAO {
	
	public int accountCreation (User user) throws BusinessException;
	public User logIn (String email, String password) throws BusinessException;
	public int findUserId (String email) throws BusinessException;
	public String findUserType (String email) throws BusinessException;

}
