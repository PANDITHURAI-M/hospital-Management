package com.hospital.management.services.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.ProfileService;

public class PatientProfileServicesImpl implements ProfileService{

	@Override
	public void profileCreation(HttpServletRequest request, HttpServletResponse response) {
		
		String driverURL = "com.mysql.cj.jdbc.Driver";
		String connectionURL="jdbc:mysql://localhost:3306/Hospital";
		String user="root";
		String dbPassWord="password";
		String insertQuery="insert into patient(name,age,address,mobile,gender) values(?,?,?,?,?)";
	
		try {
			//Registering the Driver
			Class.forName(driverURL);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			// Getting the connection via driver
			Connection connection = DriverManager.getConnection(connectionURL,user,dbPassWord);
			
			PreparedStatement preparedStatement =connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, request.getParameter("patientName"));
			preparedStatement.setInt(2, Integer.parseInt(request.getParameter("patientAge")));
			preparedStatement.setString(3, request.getParameter("patientAddress"));
			preparedStatement.setString(4, request.getParameter("patientPhoneNumber"));
			preparedStatement.setString(5, request.getParameter("patientGender"));
			
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
	public void profileUpdation(HttpServletRequest request, HttpServletResponse response) {
		
	}

	@Override
	public void profileRead(HttpServletRequest request, HttpServletResponse response) {

		String driverURL = "com.mysql.cj.jdbc.Driver";
		String connectionURL="jdbc:mysql://localhost:3306/Hospital";
		String user="root";
		String dbPassWord="password";
		String query="Select * from Hospital.doctor where patientId=?";
	
		try {
			//Registering the Driver
			Class.forName(driverURL);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			// Getting the connection via driver
			Connection connection = DriverManager.getConnection(connectionURL,user,dbPassWord);
			
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			
				
			}
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void profileDeletion(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
