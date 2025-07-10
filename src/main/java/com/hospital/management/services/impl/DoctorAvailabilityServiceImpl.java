package com.hospital.management.services.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.DoctorAvailabilityService;

public class DoctorAvailabilityServiceImpl implements DoctorAvailabilityService {

	@Override
	public void makeAvailable(HttpServletRequest request, HttpServletResponse response) {

		String driverURL = "com.mysql.cj.jdbc.Driver";
		String connectionURL="jdbc:mysql://localhost:3306/Hospital";
		String dbUser="root";
		String dbPassWord="password";
        String updateQuery ="update  Hospital.doctor set availability=true where doctorId = ?";
		
		
	
		try {
			//Registering the Driver
			Class.forName(driverURL);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			// Getting the connection via driver
			Connection connection = DriverManager.getConnection(connectionURL,dbUser,dbPassWord);
			
			PreparedStatement preparedStatement =connection.prepareStatement(updateQuery);
			
			preparedStatement.setInt(1,Integer.parseInt( request.getParameter("id")));
			
			    
			int noOfRowsAffected = preparedStatement.executeUpdate();
			
			if(noOfRowsAffected>=1) {
				try {
					response.sendRedirect("AllDoctors.jsp");
					System.out.println("Availability Change Successfull");
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
	public void makeUnAvailable(HttpServletRequest request, HttpServletResponse response) {
		String driverURL = "com.mysql.cj.jdbc.Driver";
		String connectionURL="jdbc:mysql://localhost:3306/Hospital";
		String dbUser="root";
		String dbPassWord="password";
        String updateQuery ="update  Hospital.doctor set availability=false   where doctorId = ?";
		
		
	
		try {
			//Registering the Driver
			Class.forName(driverURL);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			// Getting the connection via driver
			Connection connection = DriverManager.getConnection(connectionURL,dbUser,dbPassWord);
			
			PreparedStatement preparedStatement =connection.prepareStatement(updateQuery);
			
			preparedStatement.setInt(1,Integer.parseInt( request.getParameter("id")));
			
			    
			int noOfRowsAffected = preparedStatement.executeUpdate();
			
			if(noOfRowsAffected>=1) {
				try {
					response.sendRedirect("AllDoctors.jsp");
					System.out.println("Availability Change Successfull");
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

}
