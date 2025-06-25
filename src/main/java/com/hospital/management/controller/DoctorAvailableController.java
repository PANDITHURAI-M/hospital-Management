package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.DoctorAvailabilityService;
import com.hospital.management.services.impl.DoctorAvailabilityServiceImpl;
@WebServlet("/makeDoctorAvailable")
public class DoctorAvailableController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorAvailabilityService availableService = new DoctorAvailabilityServiceImpl();
	    availableService.makeAvailable(request, response);
		
	}
}
