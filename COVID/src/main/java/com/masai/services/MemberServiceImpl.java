
package com.masai.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.controller.MemberController;
import com.masai.exception.MemberException;
import com.masai.model.Member;
import com.masai.model.MemberShow;
import com.masai.repo.MemberRepo;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberRepo mr;

//	@Autowired
//	MemberController mc;
	
	
	@Override
	public List<MemberShow> allMember() throws MemberException {
		// TODO Auto-generated method stub
		
		List<Member> l1 = mr.findAll();
		List<MemberShow> ms = new  ArrayList<>();
		
		if(l1.size()>0) {
			
			for(Member m:l1) {
				
				MemberShow mems= new MemberShow();
//				mems.setCity(m.getIdCard().getAddress().getCity());
				  mems.setDose1Status(m.isDose1Status());
				  mems.setDose2Status(m.isDose2Status());
				  mems.setDose1Date(m.getDose1Date());
				  mems.setDose2Date(m.getDose2Date());
				  mems.setName(m.getIdCard().getName());
				  mems.setDOB(m.getIdCard().getDOB());
				  mems.setGender(m.getIdCard().getGender());
				  mems.setCity(m.getIdCard().getAddress().getCity());
				  mems.setState(m.getIdCard().getAddress().getState());
				  mems.setPinCode(m.getIdCard().getAddress().getPinCode());
                  mems.setPanNo(m.getIdCard().getPanCard().getPanNo());
                  mems.setAdharNo(m.getIdCard().getAdharCard().getAdharNo());
                  mems.setFingerprints(m.getIdCard().getAdharCard().getFingerprints());
                  mems.setIrisScan(m.getIdCard().getAdharCard().getIrisScan());
                  mems.setMobileNo(m.getVaccineRegistration().getMobileNo());
                  mems.setDateOfRegistration(LocalDate.now());
//                  if(m.getAppointment().getBookingId()==null) {
//                	  
//                  }else {
//                	  
//                	  mems.setAppointmentId(m.getAppointment().getBookingId());
//                  }
//                  private long mobileNo;
//          	    private LocalDate dateOfRegistration;
//                  private Integer  appointmentId;
				ms.add(mems);
			}	
			return ms;
		}
		else {
			throw new MemberException("no member found");
		}
	}

	@Override
	public MemberShow getMemberByld(Integer idcardid) throws MemberException {
		// TODO Auto-generated method stub
	    Optional<Member> m= mr.findById(idcardid);
		
	    
	    if(m.isPresent()) {
	    	
	    	MemberShow mems= new MemberShow();
//			mems.setCity(m.getIdCard().getAddress().getCity());
			  mems.setDose1Status(m.get().isDose1Status());
			  mems.setDose2Status(m.get().isDose2Status());
			  mems.setDose1Date(m.get().getDose1Date());
			  mems.setDose2Date(m.get().getDose2Date());
			  mems.setName(m.get().getIdCard().getName());
			  mems.setDOB(m.get().getIdCard().getDOB());
			  mems.setGender(m.get().getIdCard().getGender());
			  mems.setCity(m.get().getIdCard().getAddress().getCity());
			  mems.setState(m.get().getIdCard().getAddress().getState());
			  mems.setPinCode(m.get().getIdCard().getAddress().getPinCode());
              mems.setPanNo(m.get().getIdCard().getPanCard().getPanNo());
              mems.setAdharNo(m.get().getIdCard().getAdharCard().getAdharNo());
              mems.setFingerprints(m.get().getIdCard().getAdharCard().getFingerprints());
              mems.setIrisScan(m.get().getIdCard().getAdharCard().getIrisScan());
              mems.setMobileNo(m.get().getVaccineRegistration().getMobileNo());
              mems.setDateOfRegistration(m.get().getVaccineRegistration().getDateOfRegistration());
//              if(m.get().getAppointment().getBookingId()==null) {
////            	  
//              }
//            	  else {
//            	  
//            	  mems.setAppointmentId(m.get().getAppointment().getBookingId());
//              }
//              mems.setAppointmentId(m.get().getAppointment().getBookingId());
	    	  
	    	return mems;
	    }
	    else {
	    	throw new MemberException("no member found by id "+idcardid);
	    }
	}

	@Override
	public MemberShow getMemberByAdharNo(String adharno) throws MemberException {
		// TODO Auto-generated method stub
		
	   Member m=mr.getMemberByAdhar(adharno);
	  
	   if(m !=null) {
//	    	return m;
			MemberShow mems= new MemberShow();
//			mems.setCity(m.getIdCard().getAddress().getCity());
			  mems.setDose1Status(m.isDose1Status());
			  mems.setDose2Status(m.isDose2Status());
			  mems.setDose1Date(m.getDose1Date());
			  mems.setDose2Date(m.getDose2Date());
			  mems.setName(m.getIdCard().getName());
			  mems.setDOB(m.getIdCard().getDOB());
			  mems.setGender(m.getIdCard().getGender());
			  mems.setCity(m.getIdCard().getAddress().getCity());
			  mems.setState(m.getIdCard().getAddress().getState());
			  mems.setPinCode(m.getIdCard().getAddress().getPinCode());
              mems.setPanNo(m.getIdCard().getPanCard().getPanNo());
              mems.setAdharNo(m.getIdCard().getAdharCard().getAdharNo());
              mems.setFingerprints(m.getIdCard().getAdharCard().getFingerprints());
              mems.setIrisScan(m.getIdCard().getAdharCard().getIrisScan());
              mems.setMobileNo(m.getVaccineRegistration().getMobileNo());
              mems.setDateOfRegistration(m.getVaccineRegistration().getDateOfRegistration());
//              mems.setAppointmentId(m.getAppointment().getBookingId());
//              if(m.getAppointment().getBookingId()==null) {
//            	  
//              }else {
//            	  
//            	  mems.setAppointmentId(m.getAppointment().getBookingId());
//              }
//	    	
	    	return mems;
	    }
	    else {
	    	throw new MemberException("no member found by adharNo "+adharno);
	    }
	}

	@Override
	public MemberShow getMemberByPanNo(String panNo) throws MemberException {
		// TODO Auto-generated method stub
		
		Member m= mr.getMemberByPanNo(panNo);
		
		if(m !=null) {
//	    	return m;
			MemberShow mems= new MemberShow();
//			mems.setCity(m.getIdCard().getAddress().getCity());
			  mems.setDose1Status(m.isDose1Status());
			  mems.setDose2Status(m.isDose2Status());
			  mems.setDose1Date(m.getDose1Date());
			  mems.setDose2Date(m.getDose2Date());
			  mems.setName(m.getIdCard().getName());
			  mems.setDOB(m.getIdCard().getDOB());
			  mems.setGender(m.getIdCard().getGender());
			  mems.setCity(m.getIdCard().getAddress().getCity());
			  mems.setState(m.getIdCard().getAddress().getState());
			  mems.setPinCode(m.getIdCard().getAddress().getPinCode());
              mems.setPanNo(m.getIdCard().getPanCard().getPanNo());
              mems.setAdharNo(m.getIdCard().getAdharCard().getAdharNo());
              mems.setFingerprints(m.getIdCard().getAdharCard().getFingerprints());
              mems.setIrisScan(m.getIdCard().getAdharCard().getIrisScan());
              mems.setMobileNo(m.getVaccineRegistration().getMobileNo());
              mems.setDateOfRegistration(m.getVaccineRegistration().getDateOfRegistration());
//              mems.setAppointmentId(m.getAppointment().getBookingId());
//              if(m.getAppointment().getBookingId()==null) {
//            	  
//              }else {
//            	  
//            	  mems.setAppointmentId(m.getAppointment().getBookingId());
//              }
	    	
	    	return mems;
	    }
	    else {
	    	throw new MemberException("no member found by PanNo "+panNo);
	    }
	}

	@Override
	public MemberShow addMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		
		Member m2=mr.getMemberByAdhar(member.getIdCard().getAdharCard().getAdharNo());
		Member m3=mr.getMemberByPanNo(member.getIdCard().getPanCard().getPanNo());
		
		 if(m2 != null ){
		    	throw new MemberException("member already present with adharNo "+member.getIdCard().getAdharCard().getAdharNo());
		    }
		 else if(m3 != null){
			 throw new MemberException("member already present with pan "+member.getIdCard().getPanCard().getPanNo());
			  
		 }
	     else {
		Member m=mr.save(member);
		MemberShow mems= new MemberShow();
//		mems.setCity(m.getIdCard().getAddress().getCity());
		  mems.setDose1Status(m.isDose1Status());
		  mems.setDose2Status(m.isDose2Status());
		  mems.setDose1Date(m.getDose1Date());
		  mems.setDose2Date(m.getDose2Date());
		  mems.setName(m.getIdCard().getName());
		  mems.setDOB(m.getIdCard().getDOB());
		  mems.setGender(m.getIdCard().getGender());
		  mems.setCity(m.getIdCard().getAddress().getCity());
		  mems.setState(m.getIdCard().getAddress().getState());
		  mems.setPinCode(m.getIdCard().getAddress().getPinCode());
          mems.setPanNo(m.getIdCard().getPanCard().getPanNo());
          mems.setAdharNo(m.getIdCard().getAdharCard().getAdharNo());
          mems.setFingerprints(m.getIdCard().getAdharCard().getFingerprints());
          mems.setIrisScan(m.getIdCard().getAdharCard().getIrisScan());
          mems.setMobileNo(m.getVaccineRegistration().getMobileNo());
          mems.setDateOfRegistration(m.getVaccineRegistration().getDateOfRegistration());
//          mems.setAppointmentId(null);
    	
    	return mems;
//	    	    return m;
		  }
		
	}

	@Override
	public MemberShow updateMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		
		Optional<Member> m = mr.findById(member.getMemberId());
		
		 if(m.isPresent()){
			 
			Member m2= m.get();
			
			m2.setAppointment(member.getAppointment());
			m2.setDose1Date(member.getDose1Date());
			m2.setDose1Status(member.isDose1Status());
			m2.setDose2Date(member.getDose2Date());
			m2.setDose2Status(member.isDose2Status());
			m2.setIdCard(member.getIdCard());
			m2.setVaccineRegistration(member.getVaccineRegistration());

			mr.save(m2);
			
			MemberShow mems= new MemberShow();
//			mems.setCity(m.getIdCard().getAddress().getCity());
			  mems.setDose1Status(m2.isDose1Status());
			  mems.setDose2Status(m2.isDose2Status());
			  mems.setDose1Date(m2.getDose1Date());
			  mems.setDose2Date(m2.getDose2Date());
			  mems.setName(m2.getIdCard().getName());
			  mems.setDOB(m2.getIdCard().getDOB());
			  mems.setGender(m2.getIdCard().getGender());
			  mems.setCity(m2.getIdCard().getAddress().getCity());
			  mems.setState(m2.getIdCard().getAddress().getState());
			  mems.setPinCode(m2.getIdCard().getAddress().getPinCode());
              mems.setPanNo(m2.getIdCard().getPanCard().getPanNo());
              mems.setAdharNo(m2.getIdCard().getAdharCard().getAdharNo());
              mems.setFingerprints(m2.getIdCard().getAdharCard().getFingerprints());
              mems.setIrisScan(m2.getIdCard().getAdharCard().getIrisScan());
              mems.setMobileNo(m2.getVaccineRegistration().getMobileNo());
              mems.setDateOfRegistration(m2.getVaccineRegistration().getDateOfRegistration());
//              mems.setAppointmentId(m2.getAppointment().getBookingId());
	    	
	    	return mems;
//			return 
		    }	 
	   else{
	    	 throw new MemberException("No member found to update with  id  "+member.getMemberId());
		  }
	}

	@Override
	public boolean deleteMember(Integer member) throws MemberException {
		// TODO Auto-generated method stub
		Optional<Member> m = mr.findById(member);
		
		 if(m.isPresent()){
			 
			  mr.deleteById(member);
			  
			  return true;
		    }	 
	   else{
	    	 throw new MemberException("No member found to update with  id  "+member);
		  }
		
		
	}

	


}
