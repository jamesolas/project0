package com.app.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnection {
	
	private static Connection connection;
	private PostgresqlConnection() {

}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://database-1.cqrofvu1umtq.us-west-1.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "password";
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

//	public static Connection getConnection() throws ClassNotFoundException, SQLException{
//		Class.forName("org.postgresql.Driver");
//		String url = "jdbc:postgresql://localhost:5432/postgres";
//		String username = "postgres";
//		String password = "";
//		connection = DriverManager.getConnection(url, username, password);
//		return connection;
//	}	
}