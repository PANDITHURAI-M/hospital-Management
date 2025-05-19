package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.ProfileService;
import com.hospital.management.services.impl.PatientProfileServicesImpl;
	

@WebServlet("/createPatientProfile")
public class PatientProfileController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProfileService services = new PatientProfileServicesImpl();
		services.profileCreation(req, resp);
	}
}
