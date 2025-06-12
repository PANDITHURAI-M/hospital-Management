package com.hospital.management.services.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.ProfileService;

public class DoctorProfileServiceImpl implements ProfileService{

	@Override
	public void profileCreation(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		String insertQuery="insert into doctor(name , age , address , mobile, gender, department, experience,availability) values(?,?,?,?,?,?,?,?)";
		
		try {
			Connection connect = JdbcConnection.getConnection();
			
			PreparedStatement preparedStatement =connect.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, request.getParameter("doctorName"));
			preparedStatement.setInt(2, Integer.valueOf(request.getParameter("doctorAge")));
			preparedStatement.setString(3, request.getParameter("doctorAddress"));
			preparedStatement.setString(4, request.getParameter("doctorMobile"));
			preparedStatement.setString(5, request.getParameter("doctorGender"));
			preparedStatement.setString(6, request.getParameter("department"));
			preparedStatement.setString(7, request.getParameter("doctorExperience"));
			boolean availability = request.getParameter("doctorAvailability") !=null;
			preparedStatement.setBoolean(8,availability);
			
			    
			int noOfRowsAffected = preparedStatement.executeUpdate();
			
			if(noOfRowsAffected>=1) {
				try {
					response.sendRedirect("Login.html");
					System.out.println("Doctor Creation up success");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}else {
				System.out.println("Something went wrong");
			}
			connect.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	

	@Override
	public void profileUpdation(HttpServletRequest request, HttpServletResponse response) {
		
        
		String query="update  doctor set name=?, age = ?,address=? ,  mobile=? , gender=?,department=? , experience = ?,	availability=? where doctorId = ? ";
		String doctorId = request.getParameter("doctorId");
		String doctorName = request.getParameter("doctorName");
		String doctorage = request.getParameter("doctorAge");
		String doctorAddress = request.getParameter("doctorAddress");
		String doctorMobile = request.getParameter("doctorMobile");
		String doctorGender = request.getParameter("doctorGender");
		String department = request.getParameter("department");
		String doctorExperience = request.getParameter("doctorExperience");
//		System.out.println(request.getParameter("doctorAvailability"));
		boolean availability =request.getParameter("doctorAvailability")!=null	;
		try {
			Connection connection = JdbcConnection.getConnection();
			    PreparedStatement statement=connection.prepareStatement(query);

			    statement.setString(1, doctorName);
			    statement.setString(2, doctorage);
			    statement.setString(3, doctorAddress);
			    statement.setString(4, doctorMobile);
			    statement.setString(5, doctorGender);
			    statement.setString(6, department);
			    statement.setString(7, doctorExperience);
			    statement.setBoolean(8, availability);
			    statement.setString(9, doctorId);
			    
			    
			    
			   int noOfRowsAffected = statement.executeUpdate();
			   System.out.println(noOfRowsAffected);
			    if(noOfRowsAffected>=1) {
			    	System.out.println("Success");
			    	response.sendRedirect("dashboard.html");
			    }else {
			    	System.out.println("Error");
			    	response.sendRedirect("AllDoctors.jsp");
			    }
			    
			    connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void profileRead(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	@Override
	public void profileDeletion(HttpServletRequest request, HttpServletResponse response) {
		String query ="delete from doctor where doctorId =?";
		String id = request.getParameter("doctorId");
		try {
			Connection connection = JdbcConnection.getConnection();
		    PreparedStatement statement=connection.prepareStatement(query);
		    statement.setString(1,id );
		    int noOfRowsAffect = statement.executeUpdate();
		    
		    if(noOfRowsAffect>=1) {
		    	response.sendRedirect("AllDoctors.jsp");
		    }else {
		    	response.sendRedirect("AllDoctors.jsp");
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}


