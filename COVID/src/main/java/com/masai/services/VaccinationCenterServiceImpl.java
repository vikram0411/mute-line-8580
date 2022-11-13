package com.masai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccinationCentreException;
import com.masai.model.VaccinationCenter;
import com.masai.model.VaccinationCenterShow;
import com.masai.repo.VaccinationCenterRepo;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

	@Autowired
	private VaccinationCenterRepo vcr;
	
	@Override
	public VaccinationCenterShow getVaccineCenter(Integer centerid) throws VaccinationCentreException {
		// TODO Auto-generated method stub
		Optional<VaccinationCenter> vc=vcr.findById(centerid);
		if(vc.isPresent()) {
			
			VaccinationCenterShow vcs= new VaccinationCenterShow();
			
			vcs.setCenterName(vc.get().getCenterName());
			vcs.setCity(vc.get().getAddress().getCity());
			vcs.setCode(vc.get().getCode());
			vcs.setPinCode(vc.get().getAddress().getPinCode());
			vcs.setState(vc.get().getAddress().getState());
			if(vc.get().getVaccines()!=null) {
				
				vcs.setVaccine(vc.get().getVaccines().getVaccninName());
			}
			return vcs;
		}
		else {
		  throw new VaccinationCentreException("No vaccination center found for id"+centerid);	
		}
		
	}

	@Override
	public VaccinationCenterShow addVaccineCenter(VaccinationCenter center) throws VaccinationCentreException {
		// TODO Auto-generated method stub
		VaccinationCenter v=vcr.findByCenterName(center.getCenterName());
//		VaccinationCenter v = null;
		if(v==null) {
       VaccinationCenter vc= vcr.save(center);
			
       VaccinationCenterShow vcs= new VaccinationCenterShow();
			vcs.setCenterName(vc.getCenterName());
			vcs.setCity(vc.getAddress().getCity());
			vcs.setCode(vc.getCode());
			if(vc.getAddress()!=null) {
				
				vcs.setPinCode(vc.getAddress().getPinCode());
				vcs.setState(vc.getAddress().getState());
			}
			if(vc.getVaccines()!=null) {
				
				vcs.setVaccine(v.getVaccines().getVaccninName());
			}
			return vcs;
//			return v;
//			return center;
		} 
		else {
			throw new VaccinationCentreException("Vaccination center already present with centername"+center.getCenterName());	
				
		}
	}
//
//	@Override
	public VaccinationCenterShow updateVaccineCenter(VaccinationCenter center) throws VaccinationCentreException {
		// TODO Auto-generated method stub
		VaccinationCenter vc=vcr.findByCenterName(center.getCenterName());
//		VaccinationCenter v = null;
		if(vc!=null) {
			vc.setAddress(center.getAddress());
			vc.setAppointment(center.getAppointment());
			vc.setCenterName(center.getCenterName());
			vc.setVaccines(center.getVaccines());
			
			
        VaccinationCenterShow vcs= new VaccinationCenterShow();
			
			vcs.setCenterName(vc.getCenterName());
			vcs.setCity(vc.getAddress().getCity());
			vcs.setCode(vc.getCode());
			vcs.setPinCode(vc.getAddress().getPinCode());
			vcs.setState(vc.getAddress().getState());
			 vcr.save(vc);
			if(vc.getVaccines()!=null) {
				
				vcs.setVaccine(vc.getVaccines().getVaccninName());
			}
			return vcs;
			
		}
		else {
			 throw new VaccinationCentreException(" NO Vaccination center found to update with vaccinationCenterId"+center.getCode());	
				
		}
		
	}
//
	@Override
	public boolean deleteVaccineCenter(VaccinationCenter center) throws VaccinationCentreException {
		// TODO Auto-generated method stub
		
		Optional<VaccinationCenter> vc=vcr.findById(center.getCode());
		if(vc.isPresent()) {
			vcr.deleteById(vc.get().getCode());
			return  true;
		}
		else {
			 throw new VaccinationCentreException(" NO Vaccination center found to delete with vaccinationCenterId"+center.getCode());	
					
		}
	
	}
//
	@Override
	public List<VaccinationCenterShow> allVaccineCenters() throws VaccinationCentreException {
		// TODO Auto-generated method stub
		
		List<VaccinationCenter> lvc= vcr.findAll();
		List<VaccinationCenterShow> lvvv= new ArrayList<>();
		if(lvc.size()>0) {
			
			for(VaccinationCenter center:lvc) {
				 VaccinationCenter vc= vcr.save(center);
					
			       VaccinationCenterShow vcs= new VaccinationCenterShow();
						vcs.setCenterName(vc.getCenterName());
						vcs.setCity(vc.getAddress().getCity());
						vcs.setCode(vc.getCode());
						if(vc.getAddress()!=null) {
							
							vcs.setPinCode(vc.getAddress().getPinCode());
							vcs.setState(vc.getAddress().getState());
						}
						if(vc.getVaccines()!=null) {
							
							vcs.setVaccine(vc.getVaccines().getVaccninName());
						}
//						return vcs;
						lvvv.add(vcs);
						
						
			}
			
			return lvvv;
		}
		else {
			 throw new VaccinationCentreException(" NO Vaccination center found");	
					
		}
		
	}

}
