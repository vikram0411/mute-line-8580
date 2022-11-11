package com.masai.services;

import java.util.List;

import com.masai.exception.AppointmentException;
import com.masai.model.Appointment;
import com.masai.model.Member;

public interface AppointmentService {
    
	public List<Appointment> allAppintment()throws AppointmentException;
	
	public  Appointment getAppointment (Integer bookingid) throws AppointmentException;

	public  Appointment addAppointment ( Member member,Appointment app)throws AppointmentException;
	
	public  Appointment updateAppointment ( Member member,Appointment app)throws AppointmentException;

	public boolean deleteAppointment (Appointment app)throws AppointmentException;
	
}

