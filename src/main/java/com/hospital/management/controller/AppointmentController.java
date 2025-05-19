package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.AppointmentServices;
import com.hospital.management.services.impl.AppointmentServicesImpl;
@WebServlet("/bookAppoinment")
public class AppointmentController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AppointmentServices appoinmentServices = new AppointmentServicesImpl();
		appoinmentServices.bookAppointment(req, resp);
	}
}
