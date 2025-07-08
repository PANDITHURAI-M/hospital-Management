
package com.hospital.management.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationServices  {
   
	public void signup(HttpServletRequest req,HttpServletResponse res);
	
	public void login(HttpServletRequest req,HttpServletResponse res);
	
}
