package com.hospital.management.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DoctorAvailabilityService {

	
	public void makeAvailable(HttpServletRequest request , HttpServletResponse response);
	
	public void makeUnAvailable(HttpServletRequest request , HttpServletResponse response);
}
