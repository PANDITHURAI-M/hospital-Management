package com.hospital.management.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AppointmentServices {

   public void bookAppointment(HttpServletRequest req  , HttpServletResponse res);
}
