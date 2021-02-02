package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.User;

public interface UserService {
	
	public User createAccount(String firstName, String lastName, String email, String password) throws BusinessException;
	public User logIn (String email, String password) throws BusinessException;
	public int findUserId (String email) throws BusinessException;
	public String findType (String email) throws BusinessException;

}
