package com.masai.services;

import java.util.List;
import java.util.Optional;

import com.masai.exception.AppointmentException;
import com.masai.model.Appointment;
import com.masai.model.Member;
import com.masai.repo.AppointmentRepo;
import com.masai.repo.MemberRepo;

public class AppintmentServiceImpl implements AppointmentService{

	private AppointmentRepo ar;
	private MemberRepo mr;
	
	@Override
	public Appointment getAppointment(Integer bookingid) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Appointment> am=ar.findById(bookingid);
		if(am.isPresent()) {
			return am.get();
		}
		else {
			throw new AppointmentException("no appointment found for bookingid"+bookingid);
		}		
	}

	@Override
	public Appointment addAppointment(Member member,Appointment app) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Member> m= mr.findById(member.getMemberId());
		if(m.isPresent()) {
			if(m.get().getAppointment()==null) {
				m.get().setAppointment(app);
				mr.save(m.get());
				return app;
			}else {
				throw new AppointmentException("member have already booked appointment");	
			}
		}else {
			throw new AppointmentException("no member found with given credentials for getting appointment");
		}
		
		
	}

	@Override
	public Appointment updateAppointment(Member member,Appointment app) throws AppointmentException {
		Optional<Member> m= mr.findById(member.getMemberId());
		if(m.isPresent()) {
			if(m.get().getAppointment()!=null) {
				m.get().setAppointment(app);
				mr.save(m.get());
				return app;
			}else {
				throw new AppointmentException("no appointment for member found to be updated");	
			}
		}else {
			throw new AppointmentException("no member found with given credentials for updatind appointment");
		}
	}

	@Override
	public boolean deleteAppointment(Appointment app) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Appointment> m= ar.findById(app.getBookingId());
		if(m.isPresent()) {
			
			ar.deleteById(app.getBookingId());
			return true;
			}else {
				throw new AppointmentException("no appointment for member found to be updated");	
			}
		}	
		
	

	@Override
	public List<Appointment> allAppintment() throws AppointmentException {
		// TODO Auto-generated method stub
		List<Appointment> ls =ar.findAll();
		
		if(ls.size()>0) {
			return ls;
		}else {
			throw new AppointmentException("no appointment found");	
		}
		
		
	}


}
