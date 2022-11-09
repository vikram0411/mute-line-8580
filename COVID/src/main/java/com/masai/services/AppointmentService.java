package com.masai.services;

public interface AppointmentService {

	public  Appointment getAppointment (long bookingid);

	public  Appointment addAppointment ( Appointment app);
	
	public  Appointment updateAppointment ( Appointment app);

	public boolean deleteAppointment (Appointment app);
	
}
