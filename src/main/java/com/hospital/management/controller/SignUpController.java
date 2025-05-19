package com.hospital.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.management.services.AuthenticationServices;
import com.hospital.management.services.impl.AuthenticationServicesImplementation;

@WebServlet("/USERSIGNUP")

public class SignUpController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
		
		AuthenticationServices services = new AuthenticationServicesImplementation();
		
		services.signup(req, resp);
	}
}
