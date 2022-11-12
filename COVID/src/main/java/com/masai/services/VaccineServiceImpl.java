package com.masai.services;

import java.util.List;
import java.util.Optional;

import com.masai.exception.VaccineException;
import com.masai.model.Vaccine;
import com.masai.repo.VaccineRepo;

public class VaccineServiceImpl implements VaccineService {

	private VaccineRepo vr;
	
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
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineException {
		// TODO Auto-generated method stub
       Vaccine c=vr.getVaccinerByName(vaccine.getVaccninName());
		
		if(c!=null) {
			throw new VaccineException("a vaccine is already present with vaccine name"+vaccine.getVaccninName());
		}else {
			return vr.save(c);
		}
	}

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

	@Override
	public boolean deleteVaccine(Vaccine vaccine) throws VaccineException {
		 Optional<Vaccine> c=vr.findById(vaccine.getVaccineId());
			
			if(c.isPresent()) {
				Vaccine v= c.get();
			    vr.deleteById(vaccine.getVaccineId());
				return true;
				
			}else {
				throw new VaccineException("no vaccine found for updation by vaccine id"+vaccine.getVaccineId());
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
