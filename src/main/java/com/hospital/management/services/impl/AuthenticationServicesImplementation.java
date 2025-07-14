package com.hospital.management.services.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.management.services.AuthenticationServices;

public class AuthenticationServicesImplementation implements AuthenticationServices{

	@Override
	public void signup(HttpServletRequest request, HttpServletResponse response) {
		String driverURL = "com.mysql.cj.jdbc.Driver";
		String connectionURL="jdbc:mysql://localhost:3306/Hospital";
		String dbUser="root";
		String dbPassWord="password";
		String insertQuery="insert into Hospital.authentication (email,password) values(?,?)";
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			//Registering the Driver
			Class.forName(driverURL);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			// Getting the connection via driver
			Connection connection = DriverManager.getConnection(connectionURL,dbUser,dbPassWord);
			
			PreparedStatement preparedStatement =connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			
			if(noOfRowsAffected>=1) {
				try {
					response.sendRedirect("Login.html");
					System.out.println("User Sign up success");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}else {
				System.out.println("Something went wrong");
			}
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
	
		String driverURL = "com.mysql.cj.jdbc.Driver";
		String connectionURL="jdbc:mysql://localhost:3306/Hospital";
		String dbUser="root";
		String dbPassWord="password";
		String insertQuery="select * from authentication where email=? and password=?";
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println("UserPassword :"+password);
		try {
			//Registering the Driver
			Class.forName(driverURL);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			// Getting the connection via driver
			Connection connection = DriverManager.getConnection(connectionURL,dbUser,dbPassWord);
			
			PreparedStatement preparedStatement =connection.prepareStatement(insertQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				
				 String dbUserPassWord = resultSet.getString("password");
				System.out.println(dbUserPassWord);
				if(password.equals(dbUserPassWord)) {
					System.out.println("Password matched");
					try {
						HttpSession session = request.getSession();
						session.setAttribute("UserName", resultSet.getString("email")); // session current executing object 					
						response.sendRedirect("dashboard.html");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
			}
			else {
				
				System.out.println("Wrong password");
				try {
					response.sendRedirect("Login.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			 
			          
			}
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
}
