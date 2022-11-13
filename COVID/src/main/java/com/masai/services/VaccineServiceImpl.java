package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccineException;
import com.masai.model.VaccinationCenter;
import com.masai.model.Vaccine;
import com.masai.repo.VaccinationCenterRepo;
import com.masai.repo.VaccineRepo;


@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepo vr;
	
	@Autowired
	private VaccinationCenterRepo vcr;
	
	@Override
	public Vaccine getVaccineByName(String vaccineName) throws VaccineException {
		// TODO Auto-generated method stub
		Vaccine c=vr.getVaccinerByName(vaccineName);
		
		if(c!=null) {
			return c;
		}else {
			throw new VaccineException("no vaccine found with this vaccine name");
		}
		
	}
//
	@Override
	public Vaccine getVaccinebyld(Integer vaccineld) throws VaccineException {
		// TODO Auto-generated method stub
        Optional<Vaccine> c=vr.findById(vaccineld);
		
		if(c.isPresent()) {
			return c.get();
		}else {
			throw new VaccineException("no vaccine found by vaccine id"+vaccineld);
		}
		 
		
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine,Integer VaccinneCenterId) throws VaccineException {
		// TODO Auto-generated method stub
		
		Optional<VaccinationCenter> vaccen= vcr.findById(VaccinneCenterId);
		
		if(vaccen.isPresent()) {
			
			Vaccine c=vr.getVaccinerByName(vaccine.getVaccninName());
			
			
			if(c!=null) {
				throw new VaccineException("a vaccine is already present with vaccine name"+vaccine.getVaccninName());
			}else {
				vaccine.setVaccinationCenters(vaccen.get());
				vaccen.get().setVaccines(vaccine);
				 vcr.save(vaccen.get());
				return vr.save(vaccine);
			}
		}else {
			throw new VaccineException("No vacinationCenter present with id"+VaccinneCenterId	);
		}
	}
//
	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException {
		
		// TODO Auto-generated method stub
		 Optional<Vaccine> c=vr.findById(vaccine.getVaccineId());
		
			if(c.isPresent()) {
				Vaccine v= c.get();
				v.setDescription(vaccine.getDescription());
				v.setVaccinationCenters(vaccine.getVaccinationCenters());
				v.setVaccineInventory(vaccine.getVaccineInventory());
				v.setVaccninName(vaccine.getVaccninName());
				return vr.save(v);
				
			}else {
				throw new VaccineException("no vaccine found for updation by vaccine id");
			}
	}
	
	
//
	@Override
	public boolean deleteVaccine(Integer id) throws VaccineException {
		 Optional<Vaccine> c=vr.findById(id);
			
			if(c.isPresent()) {
				Vaccine v= c.get();
			    vr.deleteById(id);
				return true;
				
			}else {
				throw new VaccineException("no vaccine found for updation by vaccine id"+id);
			}
	}
	
	
	
	@Override
	public List<Vaccine> allVaccine() throws VaccineException {
		// TODO Auto-generated method stub
		List<Vaccine> lv=vr.findAll();
		if(lv.size()>0){
			return lv;
		}else {
			throw new VaccineException("no vaccine found ");
		}
		
	}

}
