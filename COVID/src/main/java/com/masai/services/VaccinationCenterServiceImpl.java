package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccinationCentreException;
import com.masai.model.VaccinationCenter;
import com.masai.repo.VaccinationCenterRepo;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

	@Autowired
	private VaccinationCenterRepo vcr;
	
	@Override
	public VaccinationCenter getVaccineCenter(Integer centerid) throws VaccinationCentreException {
		// TODO Auto-generated method stub
		Optional<VaccinationCenter> vc=vcr.findById(centerid);
		if(vc.isPresent()) {
			return vc.get();
		}
		else {
		  throw new VaccinationCentreException("No vaccination center found for id"+centerid);	
		}
		
	}

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center) throws VaccinationCentreException {
		// TODO Auto-generated method stub
		VaccinationCenter v=vcr.findByCenterName(center.getCenterName());
//		VaccinationCenter v = null;
		if(v==null) {
//			return v;
			VaccinationCenter vc= vcr.save(center);
			return center;
		} 
		else {
			throw new VaccinationCentreException("Vaccination center already present with centername"+center.getCenterName());	
				
		}
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center) throws VaccinationCentreException {
		// TODO Auto-generated method stub
		VaccinationCenter v=vcr.findByCenterName(center.getCenterName());
//		VaccinationCenter v = null;
		if(v!=null) {
			v.setAddress(center.getAddress());
			v.setAppointment(center.getAppointment());
			v.setCenterName(center.getCenterName());
			v.setVaccines(center.getVaccines());
			
			return vcr.save(v);
		}
		else {
			 throw new VaccinationCentreException(" NO Vaccination center found to update with vaccinationCenterId"+center.getCode());	
				
		}
		
	}

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

	@Override
	public List<VaccinationCenter> allVaccineCenters() throws VaccinationCentreException {
		// TODO Auto-generated method stub
		
		List<VaccinationCenter> lvc= vcr.findAll();
		if(lvc.size()>0) {
			return lvc;
		}
		else {
			 throw new VaccinationCentreException(" NO Vaccination center found");	
					
		}
		
	}

}
