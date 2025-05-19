
package com.hospital.management.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationServices  {
   
	public void signup(HttpServletRequest request,HttpServletResponse response);
	
	public void login(HttpServletRequest request,HttpServletResponse response);
	
}
