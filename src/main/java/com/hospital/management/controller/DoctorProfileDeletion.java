package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.ProfileService;
import com.hospital.management.services.impl.DoctorProfileServiceImpl;
@WebServlet("/deleteDoctorProfile")
public class DoctorProfileDeletion extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfileService service = new DoctorProfileServiceImpl();
		service.profileDeletion(request, response);
	}
}
