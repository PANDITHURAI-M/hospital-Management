package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.DoctorAvailabilityService;
import com.hospital.management.services.impl.DoctorAvailabilityServiceImpl;
@WebServlet("/makeDoctorUnAvailable")
public class DoctorUnAvailableController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DoctorAvailabilityService availableService = new DoctorAvailabilityServiceImpl();
		availableService.makeUnAvailable(req, resp);
	}
}
