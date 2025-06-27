package com.hospital.management.services.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
      
	public static Connection connection=null;
	
	public static Connection  getConnection() {

    String driverURL = "com.mysql.cj.jdbc.Driver";
    String connectionURL = "jdbc:mysql://localhost:3306/Hospital";
    String dbUser = "root";
    String dbPassWord = "password";
    
    try {
		Class.forName(driverURL);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    try {
		connection=DriverManager.getConnection(connectionURL, dbUser, dbPassWord);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
	return connection;
	}
	 
	
	
}
