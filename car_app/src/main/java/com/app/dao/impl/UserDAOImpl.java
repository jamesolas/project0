package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.UserDAO;
import com.app.dbutil.ConnectionClosers;
import com.app.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.Main;
import com.app.model.User;

public class UserDAOImpl  implements UserDAO {
	
	private static Logger log = Logger.getLogger(Main.class);

	@Override
	public int accountCreation(User user) throws BusinessException {
		int a = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into project0.user (firstName, lastName, email, password, type) "
					+ "values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, "customer");
			a = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred");
		}
		
		return a;
	}

	@Override
	public User logIn(String email, String password) throws BusinessException {
		User user = null;
		String type = null;
		Connection connection = null;
		
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select email, password, type from project0.user where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					user = new User();
					user.setEmail(email);
					user.setPassword(password);
					user.setType(resultSet.getString("type"));
					type = resultSet.getString("type");
				}else{
					System.out.println("Email and password do not match.");
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionClosers.close(connection);
		}		
		return user;
	}

	@Override
	public int findUserId(String email) throws BusinessException {
		int userId = 0;
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "select userid from project0.user where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();	
				if(resultSet.next()) {
						userId =  resultSet.getInt("userId");		
				}else {
					throw new BusinessException("No id found.");
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return userId;
	}

	@Override
	public String findUserType(String email) throws BusinessException {
		String type = null;
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "select type from project0.user where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();	
				if(resultSet.next()){
					type =  resultSet.getString("type");		
				}else {
					throw new BusinessException("No email found.");
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return type;
	}

	

}
