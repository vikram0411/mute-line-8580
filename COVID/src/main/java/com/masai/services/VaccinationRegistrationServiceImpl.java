package com.masai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.masai.exception.VaccineRgistrationException;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;
import com.masai.repo.MemberRepo;
import com.masai.repo.VaccineRegistrationRepo;

public class VaccinationRegistrationServiceImpl implements VaccinationRegistrationService {

	private VaccineRegistrationRepo vrr;
	
	@Override
	public List<VaccineRegistration> getVaccineRegistration(long mobileno)throws VaccineRgistrationException {
		// TODO Auto-generated method stub
		
		List<Member> m=vrr.getMemberBymobile(mobileno);
		
		List<VaccineRegistration> vr = new ArrayList<>();
		if(m.size()>0) {	
			for(Member mm:m) {
				
				if(mm!=null) {
					vr.add(mm.getVaccineRegistration());
				}
			}
			return vr;
		}	
	else {
		throw new VaccineRgistrationException ("no registration found with mobile no"+mobileno);
	}
	}

	@Override
	public List<Member> getAllMember(long mobileno) throws VaccineRgistrationException {
		
		List<Member> m=vrr.getMemberBymobile(mobileno);
		if(m.size()>0) {	
			return m;		}	
	else {
		throw new VaccineRgistrationException ("no Member found with mobile no"+mobileno);
	}
	}

	@Override
	public VaccineRegistration addVaccineRegistration(Member member,VaccineRegistration reg) throws VaccineRgistrationException {
		// TODO Auto-generated method stub
		Optional<Member> m=vrr.findById(member.getMemberId());
        if(m.isPresent()) {
        	
        	Member m2= m.get();
        	if(m2.getVaccineRegistration()==null) {
        		m2.setVaccineRegistration(reg);
        	}else {
        		throw new VaccineRgistrationException ("member have already registerd for vaccine");
 
	
        	}
        }

        	throw new VaccineRgistrationException ("no Member found for givencreadentials");
        
		
		
		
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(Member member,VaccineRegistration reg) throws VaccineRgistrationException {
		// TODO Auto-generated method stub
		Optional<Member> m=vrr.findById(member.getMemberId());
        if(m.isPresent()) {
        	
        	Member m2= m.get();
        	if(m2.getVaccineRegistration()==null) {
        		throw new VaccineRgistrationException ("No registration done for updation");
        	}else {
        		m2.setVaccineRegistration(reg);	
        	}
        }
        	throw new VaccineRgistrationException ("no Member found for givencreadentials");
	}

	@Override
	public boolean deleteVaccineRegistration(Member member) throws VaccineRgistrationException {
	
		Optional<Member> m=vrr.findById(member.getMemberId());
		if(m.isPresent()) {
			if(m.get().getVaccineRegistration()==null) {
				
				throw new VaccineRgistrationException ("no Vaccine registraion present to delete");
			}else {
				return true;
			}
		}else {
			throw new VaccineRgistrationException ("no Member found for given creadentials");
		}
		
		
	}

	@Override
	public List<VaccineRegistration> allVaccineRegistrations() throws VaccineRgistrationException {
	   
		List<Member> lm= vrr.findAll();
		
		List<VaccineRegistration> lvr = new ArrayList<>();
		if(lm.size()>0) {
			for(Member m:lm) {
				if(m.getVaccineRegistration()!=null) {
					lvr.add(m.getVaccineRegistration());
				}
			}
			if(lvr.size()>0) {
				return lvr;
			}else {
				throw new VaccineRgistrationException ("no registrations found");
			}
		}else {
			throw new VaccineRgistrationException ("no registrations found");
		}	
	}

}
