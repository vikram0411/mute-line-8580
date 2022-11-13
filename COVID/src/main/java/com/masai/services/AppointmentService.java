package com.masai.services;

import java.util.List;

import com.masai.exception.AppointmentException;
import com.masai.model.Appointment;
import com.masai.model.Member;
import com.masai.model.ShowAppointment;
import com.masai.model.VaccinationCenter;

public interface AppointmentService {
    
	public List<ShowAppointment> allAppintment()throws AppointmentException;
//	
	public  ShowAppointment getAppointment (Integer bookingid) throws AppointmentException;
//
	public  ShowAppointment addAppointment (Integer memberid,Appointment app,Integer vc)throws AppointmentException;
//	
	public boolean deleteAppointment (Integer mid, Integer app)throws AppointmentException;
//	
	ShowAppointment updateAppointment(Integer mid, Appointment app) throws AppointmentException;
//	boolean deleteAppointment(Integer mid, Integer app) throws AppointmentException;
}

