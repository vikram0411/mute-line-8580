package com.masai.services;

import java.util.List;

import com.masai.model.Appointment;

public interface AppointmentService {
    
	public List<Appointment> allAppintment();
	
	public  Appointment getAppointment (long bookingid);

	public  Appointment addAppointment ( Appointment app);
	
	public  Appointment updateAppointment ( Appointment app);

	public boolean deleteAppointment (Appointment app);
	
}

