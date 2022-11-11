package com.masai.services;

import java.util.List;
import java.util.Optional;

import com.masai.exception.MemberException;
import com.masai.model.Member;
import com.masai.repo.MemberRepo;

public class MemberServiceImpl implements MemberService{
	public MemberRepo mr;

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
		
		Member m = mr.getMemberByAdhar(member.getIdCard().getAdharCard().getAdharNo());
		
		 if(m != null){
		    	throw new MemberException("member already present with adharNo "+member.getIdCard().getAdharCard().getAdharNo());
		    }	 
	     else {
	    	    return mr.save(member);
		  }
		
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
