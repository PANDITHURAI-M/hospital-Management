package com.hospital.management.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProfileService {

	public void profileCreation(HttpServletRequest request, HttpServletResponse response);
	
	public void profileUpdation(HttpServletRequest request, HttpServletResponse response);
	
	public void profileRead(HttpServletRequest request, HttpServletResponse response);
	
	public void profileDeletion(HttpServletRequest request, HttpServletResponse response);

}
