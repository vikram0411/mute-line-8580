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
import com.masai.repo.VaccinationCenterRepo;

@Service
public class AppintmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentRepo ar;
	@Autowired
	private MemberRepo mr;
	@Autowired
	private VaccinationCenterRepo vcr;
//	
	@Override
	public ShowAppointment getAppointment(Integer bookingid) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Appointment> am=ar.findById(bookingid);
		if(am.isPresent()) {
			Appointment a= am.get();
			
//			 ShowAppointment sa= new ShowAppointment();
			 ShowAppointment sa= new ShowAppointment();
				sa.setBookingId(a.getBookingId());
				sa.setBookingStatus(a.isBookingStatus());
				sa.setDateOfBooking(a.getDateOfBooking());
				sa.setMemberId(a.getMember().getMemberId());
				sa.setMobileNo(a.getMobileNo());
				sa.setVaccinationCenterCode(a.getVaccinationCenters().getCode());
			    return  sa;
		}
		else {
			throw new AppointmentException("no appointment found for bookingid"+bookingid);
		}		
	}
	
	
//
	@Override
	public ShowAppointment addAppointment(Integer memberid,Appointment app,Integer vc) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Member> m= mr.findById(memberid);
		if(m.isPresent()) {
			if(m.get().getAppointment()==null) {
				app.setMember(m.get());
				
				Optional<VaccinationCenter> apoi= vcr.findById(vc);
				
				if(apoi.isPresent()) {
					
					app.setVaccinationCenters(apoi.get());;
					Appointment a=ar.save(app);
				m.get().setAppointment(app);
					
//				mr.save(m.get());
					ShowAppointment sa= new ShowAppointment();
					sa.setBookingId(a.getBookingId());
					sa.setBookingStatus(a.isBookingStatus());
					sa.setDateOfBooking(a.getDateOfBooking());
					sa.setMemberId(a.getMember().getMemberId());
					sa.setMobileNo(a.getMobileNo());
					sa.setVaccinationCenterCode(vc);

					return sa;
				}else {
					throw new AppointmentException("no vaccination center present with id : "+vc);	
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
//				apo.get().setVaccinationCenters(app.getVaccinationCenters());
				ar.save(apo.get());
//				m.get().setAppointment(app);
//				mr.save(m.get());
			    ShowAppointment sa= new ShowAppointment();
			    sa.setBookingId(apo.get().getBookingId());
			    sa.setBookingStatus(apo.get().isBookingStatus());
			    sa.setMobileNo(apo.get().getMobileNo());
//			    sa.setDateOfBooking(apo.get().getDateOfBooking());
//			    sa.setMemberId(mid);
			    
//				sa.setMemberId(a.getMember().getMemberId());
//				sa.setVaccinationCenterCode(apo.get().getVaccinationCenters().getCode());
			    
//			    sa.setMobileNo(apo.get().getMobileNo());
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
		    s.setVaccinationCenterCode(a.getVaccinationCenters().getCode());
		    sa.add(s);
		}
		
			return sa;
		}else {
			throw new AppointmentException("no appointment found");	
		}
		
		
	}

	@Override
	public String vaccinated(Integer id) throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Member> m= mr.findById(id);
		if(m.isPresent()) {
			if(m.get().getAppointment()!=null) {
			Member m2=m.get();
			if(m2.getDose1Date()==null) {
				m2.setDose1Date(LocalDate.now());
				m2.setDose1Status(true);
				mr.save(m2);
				return "First dose vaccination done";
			}
			else if(m2.getDose2Date()==null) {
				m2.setDose2Date(LocalDate.now());
				m2.setDose2Status(true);
				mr.save(m2);
				return "Second dose vaccination done";
			}else {
				throw new AppointmentException("you are already fully vaccinated");
			}
			}
			else {
				throw new AppointmentException("first get a appointment");
			}
		}else {
			throw new AppointmentException("no member found with id : "+id);
		}	
	}
}
