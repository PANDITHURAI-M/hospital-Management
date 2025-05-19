 package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.AuthenticationServices;
import com.hospital.management.services.impl.AuthenticationServicesImplementation;
@WebServlet("/USERLOGIN")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthenticationServices services = new AuthenticationServicesImplementation();
		
		services.login(req, resp);
	}
}
