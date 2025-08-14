package com.hospital.management.controller;




import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.ProfileService;
import com.hospital.management.services.impl.DoctorProfileServiceImpl;
@WebServlet("/updateDoctorProfile")
public class DoctorProfileUpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	
	DoctorProfileServiceImpl s = new DoctorProfileServiceImpl();
	s.profileUpdation(request, response);
	
	
}
}
