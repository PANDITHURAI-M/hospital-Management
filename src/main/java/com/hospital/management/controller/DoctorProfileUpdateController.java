package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.ProfileService;
import com.hospital.management.services.impl.DoctorProfileServiceImpl;
@WebServlet("/updateDoctorProfile")
public class DoctorProfileUpdateController extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
	System.out.println("Came to controller");
	DoctorProfileServiceImpl service = new DoctorProfileServiceImpl();
	service.profileUpdation(req, resp);
	System.out.println("completed  controller");
	
}
}
