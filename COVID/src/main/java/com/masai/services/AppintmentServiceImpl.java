package com.masai.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AppointmentException;
import com.masai.model.Appointment;
import com.masai.model.Member;
import com.masai.model.ShowAppointment;
import com.masai.model.VaccinationCenter;
import com.masai.repo.AppointmentRepo;
import com.masai.repo.MemberRepo;

@Service
public class AppintmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentRepo ar;
	@Autowired
	private MemberRepo mr;
//	
	@Override
	public ShowAppointment getAppointment(Integer bookingid) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Appointment> am=ar.findById(bookingid);
		if(am.isPresent()) {
			Appointment a= am.get();
			
			 ShowAppointment sa= new ShowAppointment();
			    sa.setBookingId(a.getBookingId());
			    sa.setBookingStatus(a.isBookingStatus());
			    sa.setDateOfBooking(a.getDateOfBooking());
			    sa.setMemberId(a.getMember().getMemberId());
			    sa.setMobileNo(a.getMobileNo());
			    return  sa;
		}
		else {
			throw new AppointmentException("no appointment found for bookingid"+bookingid);
		}		
	}
//
	@Override
	public ShowAppointment addAppointment(Integer memberid,Appointment app,VaccinationCenter vc) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Member> m= mr.findById(memberid);
		if(m.isPresent()) {
			if(m.get().getAppointment()==null) {
				app.setMember(m.get());
				
				Optional<Appointment> apoi= ar.findById(app.getBookingId());
				
				if(apoi.isPresent()) {
					
					Appointment a=ar.save(app);
//				m.get().setAppointment(app);
					
//				mr.save(m.get());
					ShowAppointment sa= new ShowAppointment();
					sa.setBookingId(a.getBookingId());
					sa.setBookingStatus(a.isBookingStatus());
					sa.setDateOfBooking(a.getDateOfBooking());
					sa.setMemberId(a.getMember().getMemberId());
					sa.setMobileNo(a.getMobileNo());
					
					return sa;
				}else {
					throw new AppointmentException("ticket id is wrong");	
				}
				
				
			}else {
				throw new AppointmentException("member have already booked appointment");	
			}
		}else {
			throw new AppointmentException("no member found with given credentials for getting appointment");
		}
		
		
	}
//
	
	//dikkat
	@Override
	public ShowAppointment updateAppointment(Integer mid,Appointment app) throws AppointmentException {
		Optional<Member> m= mr.findById(mid);
		if(m.isPresent()) {
			if(m.get().getAppointment()!=null) {
				
				Optional<Appointment> apo= ar.findById(app.getBookingId());
				apo.get().setDateOfBooking(LocalDate.now());   
				apo.get().setMobileNo(app.getMobileNo());
				apo.get().setSlot(app.getSlot());
				apo.get().setVaccinationCenters(app.getVaccinationCenters());
				ar.save(apo.get());
//				m.get().setAppointment(app);
//				mr.save(m.get());
			    ShowAppointment sa= new ShowAppointment();
			    sa.setBookingId(apo.get().getBookingId());
			    sa.setBookingStatus(apo.get().isBookingStatus());
			    sa.setDateOfBooking(apo.get().getDateOfBooking());
			    sa.setMemberId(mid);
			    
			    sa.setMobileNo(apo.get().getMobileNo());
				return sa;
				
//				return app;
			}else {
				throw new AppointmentException("no appointment for member found to be updated");	
			}
		}else {
			throw new AppointmentException("no member found with given credentials for updatind appointment");
		}
	}
//
	@Override
	public boolean deleteAppointment(Integer mid,Integer app) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Member> mem= mr.findById(mid);
		if(mem.isPresent()) {
		
		Optional<Appointment> m= ar.findById(app);
		if(m.isPresent()) {
			
			ar.deleteById(app);
			return true;
	    }else {
				throw new AppointmentException("Wrong appintment booking id :asking for securuty purpose");	
		}
		
		}else {
			throw new AppointmentException("no  member with is peresent with id"+mid);
		}
//		
	}
//
	@Override
	public List<ShowAppointment> allAppintment() throws AppointmentException {
		// TODO Auto-generated method stub
		List<Appointment> ls =ar.findAll();
		
		if(ls.size()>0) {
		List<ShowAppointment> sa=new ArrayList<>();
		
		for(Appointment a:ls) {
			ShowAppointment s= new ShowAppointment();
			s.setBookingId(a.getBookingId());
		    s.setBookingStatus(a.isBookingStatus());
		    s.setDateOfBooking(a.getDateOfBooking());
		    s.setMemberId(a.getMember().getMemberId());
		    s.setMobileNo(a.getMobileNo());	
		    sa.add(s);
		}
		
			return sa;
		}else {
			throw new AppointmentException("no appointment found");	
		}
		
		
	}


}
