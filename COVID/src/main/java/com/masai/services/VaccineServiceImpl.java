package com.masai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccineException;
import com.masai.model.ShowVaccine;
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
	public List<ShowVaccine> getVaccineByName(String vaccineName) throws VaccineException {
		// TODO Auto-generated method stub
		List<Vaccine> c=vr.getVaccinerByName(vaccineName);
		if(c.size()>0) {
		
		List<ShowVaccine> sv = new ArrayList<>();
		
		for(Vaccine v:c) {
//			sv.add)
			ShowVaccine sv2 = new ShowVaccine();
			sv2.setVaccineId(v.getVaccineId());
			sv2.setVaccninName(v.getVaccninName());
			sv2.setDescription(v.getDescription());
			sv2.setPrice(v.getVaccineInventory().getVaccineCount().getPrice());
			sv2.setDate(v.getVaccineInventory().getDate());
			sv2.setQuantity(v.getVaccineInventory().getVaccineCount().getQuantity());
			sv2.setVaccinecenterId(v.getVaccineId());
			
			sv.add(sv2);
		}
		
			return sv;
		}else {
			throw new VaccineException("no vaccine found with this vaccine name");
		}
		
	}
//
	@Override
	public ShowVaccine getVaccinebyld(Integer vaccineld) throws VaccineException {
		// TODO Auto-generated method stub
        Optional<Vaccine> c=vr.findById(vaccineld);
		
        
		if(c.isPresent()) {
			ShowVaccine sv2 = new ShowVaccine();
			sv2.setVaccineId(c.get().getVaccineId());
			sv2.setVaccninName(c.get().getVaccninName());
			sv2.setDescription(c.get().getDescription());
			sv2.setPrice(c.get().getVaccineInventory().getVaccineCount().getPrice());
			sv2.setDate(c.get().getVaccineInventory().getDate());
			sv2.setQuantity(c.get().getVaccineInventory().getVaccineCount().getQuantity());
			sv2.setVaccinecenterId(c.get().getVaccineId());
			
//			sv.add(sv2);
			
			return sv2;
		}else {
			throw new VaccineException("no vaccine found by vaccine id"+vaccineld);
		}
	}

	@Override
	public ShowVaccine addVaccine(Vaccine vaccine,Integer VaccinneCenterId) throws VaccineException {
		// TODO Auto-generated method stub
		
		Optional<VaccinationCenter> vaccen= vcr.findById(VaccinneCenterId);
		
		if(vaccen.isPresent()) {
			
//			Vaccine c=vr.getVaccinerByName(vaccine.getVaccninName());
			
			
			if(vaccen.get().getVaccines()!=null) {
				throw new VaccineException("a vaccine is already present with vaccine name : "+vaccine.getVaccninName());
			}else {
				vaccine.setVaccinationCenters(vaccen.get());
				vaccen.get().setVaccines(vaccine);
//				 vcr.save(vaccen.get());
				vr.save(vaccine);
				
				ShowVaccine sv= new ShowVaccine();
				sv.setVaccineId(vaccine.getVaccineId());
				sv.setVaccninName(vaccine.getVaccninName());
				sv.setDescription(vaccine.getDescription());
				sv.setPrice(vaccine.getVaccineInventory().getVaccineCount().getPrice());
				sv.setDate(vaccine.getVaccineInventory().getDate());
				sv.setQuantity(vaccine.getVaccineInventory().getVaccineCount().getQuantity());
				sv.setVaccinecenterId(VaccinneCenterId);
		
				return sv;
			}
		}else {
			throw new VaccineException("No vacinationCenter present with id"+VaccinneCenterId	);
		}
	}
//
	@Override
	public ShowVaccine updateVaccine(Vaccine vaccine) throws VaccineException {
		
		// TODO Auto-generated method stub
		 Optional<Vaccine> c=vr.findById(vaccine.getVaccineId());
		
			if(c.isPresent()) {
				Vaccine v= c.get();
				v.setDescription(vaccine.getDescription());
				v.setVaccinationCenters(vaccine.getVaccinationCenters());
				v.setVaccineInventory(vaccine.getVaccineInventory());
				v.setVaccninName(vaccine.getVaccninName());
				vr.save(v);
				
				ShowVaccine sv= new ShowVaccine();
				sv.setVaccineId(vaccine.getVaccineId());
				sv.setVaccninName(vaccine.getVaccninName());
				sv.setDescription(vaccine.getDescription());
				sv.setPrice(vaccine.getVaccineInventory().getVaccineCount().getPrice());
				sv.setDate(vaccine.getVaccineInventory().getDate());
				sv.setQuantity(vaccine.getVaccineInventory().getVaccineCount().getQuantity());
				sv.setVaccinecenterId(vaccine.getVaccineId());
				
				return sv;
				
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
	public List<ShowVaccine> allVaccine() throws VaccineException {
		// TODO Auto-generated method stub
		List<Vaccine> c=vr.findAll();
		
		if(c.size()>0) {
       List<ShowVaccine> sv = new ArrayList<>();
		
		for(Vaccine v:c) {
//			sv.add)
			ShowVaccine sv2 = new ShowVaccine();
			sv2.setVaccineId(v.getVaccineId());
			sv2.setVaccninName(v.getVaccninName());
			sv2.setDescription(v.getDescription());
			sv2.setPrice(v.getVaccineInventory().getVaccineCount().getPrice());
			sv2.setDate(v.getVaccineInventory().getDate());
			sv2.setQuantity(v.getVaccineInventory().getVaccineCount().getQuantity());
			sv2.setVaccinecenterId(v.getVaccineId());
			
			sv.add(sv2);
		}
		
			return sv;
		}else {
			throw new VaccineException("no vaccine found ");
		}
		
	}

}
