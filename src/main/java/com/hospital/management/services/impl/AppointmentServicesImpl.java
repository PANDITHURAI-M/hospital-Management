package com.hospital.management.services.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.hospital.management.services.AppointmentServices;

public class AppointmentServicesImpl implements AppointmentServices {

	public void bookAppointment(HttpServletRequest request, HttpServletResponse response) {

    String driverURL = "com.mysql.cj.jdbc.Driver";
    String connectionURL = "jdbc:mysql://localhost:3306/Hospital";
    String dbuser = "root";
    String dbPassWord = "password";
    String query = "insert into appointment(doctorId,doctorName,patientId,dateAndtime,department,payment,status) values(?,?,?,?,?,?,'Booked')";
    		
    Connection connection =null;
    PreparedStatement preparedStatement=null;
    	
    String department = request.getParameter("department");
    String patentId = request.getParameter("patientId");
    String payment = request.getParameter("payment");
    String dateAndTime = request.getParameter("DateAndTime");
    String doctorOption = request.getParameter("doctorOption"); 
    String[] values=new String[2];
    String doctorId=null;
    String doctorName=null ;
    if (doctorOption != null) {
         values = doctorOption.split("\\|");
         doctorId = values[0];
         doctorName = values[1];
        
    }
   try {
    // Registering the Driver
     Class.forName(driverURL);

  
        // Establishing connection
         connection = DriverManager.getConnection(connectionURL, dbuser, dbPassWord);
        // Preparing statement
         preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         preparedStatement.setString(1, doctorId);
         preparedStatement.setString(2, doctorName);
         preparedStatement.setString(3, patentId);
         preparedStatement.setString(4, dateAndTime);
         preparedStatement.setString(5, department);
         preparedStatement.setString(6, payment);
        int noOfRowsAffected= preparedStatement.executeUpdate();
        if(noOfRowsAffected>=1) {
        	System.out.println("Booked Successfully");
        }else {
        	System.out.println("Something went wrong");
        }
	
   }catch(Exception e) {
	   e.printStackTrace();
   }finally {
	   if(connection!=null) {
		   try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   if(preparedStatement!=null) {
		   try {
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
   }
	}
}

 
