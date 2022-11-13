package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.controller.MemberController;
import com.masai.exception.MemberException;
import com.masai.model.Member;
import com.masai.repo.MemberRepo;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberRepo mr;

//	@Autowired
//	MemberController mc;
	
	
	@Override
	public List<Member> allMember() throws MemberException {
		// TODO Auto-generated method stub
		
		
		List<Member> l1 = mr.findAll();
		if(l1.size()>0) {
			return l1;
		}
		else {
			throw new MemberException("no member found");
		}
	}

	@Override
	public Member getMemberByld(Integer idcardid) throws MemberException {
		// TODO Auto-generated method stub
	    Optional<Member> m= mr.findById(idcardid);
		
	    if(m.isPresent()) {
	    	return m.get();
	    }
	    else {
	    	throw new MemberException("no member found by id "+idcardid);
	    }
	}

	@Override
	public Member getMemberByAdharNo(String adharno) throws MemberException {
		// TODO Auto-generated method stub
		
	   Member m=mr.getMemberByAdhar(adharno);
	  
	   if(m !=null) {
	    	return m;
	    }
	    else {
	    	throw new MemberException("no member found by adharNo "+adharno);
	    }
	}

	@Override
	public Member getMemberByPanNo(String panNo) throws MemberException {
		// TODO Auto-generated method stub
		
		Member m= mr.getMemberByPanNo(panNo);
		
		if(m !=null) {
	    	return m;
	    }
	    else {
	    	throw new MemberException("no member found by PanNo "+panNo);
	    }
	}

	@Override
	public Member addMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		
		
//		 if(m != null){
//		    	throw new MemberException("member already present with adharNo "+member.getIdCard().getAdharCard().getAdharNo());
//		    }	 
//	     else {
		Member m=mr.save(member);
	    	    return m;
//		  }
		
	}

	@Override
	public Member updateMember(Member member) throws MemberException {
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

			return mr.save(m2);
		    }	 
	   else{
	    	 throw new MemberException("No member found to update with  id  "+member.getMemberId());
		  }
	}

	@Override
	public boolean deleteMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		Optional<Member> m = mr.findById(member.getMemberId());
		
		 if(m.isPresent()){
			 
			  mr.deleteById(member.getMemberId());
			  
			  return true;
		    }	 
	   else{
	    	 throw new MemberException("No member found to update with  id  "+member.getMemberId());
		  }
		
		
	}



}
