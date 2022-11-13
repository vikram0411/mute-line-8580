package com.masai.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.VaccineInventoryException;
import com.masai.model.VaccinationCenter;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;
import com.masai.repo.VaccineInventoryRepo;
import com.masai.repo.VaccineRepo;


@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService {

//	private VaccineInventoryRepo vir;
//	private VaccineRepo vr;
//	@Override
//	public VaccineInventory getVaccineinventoryByCenter(Integer centerid) throws VaccineInventoryException {
//		// TODO Auto-generated method stub
//		
//		Optional<VaccinationCenter> vi = vir.findById(centerid);
//		if(vi.isPresent()) {
//			return vi.get().getVaccines().getVaccineInventory();
//		}else {
//			throw new VaccineInventoryException("no VaccineInventory found with centerId"+centerid);
//		}
//		
//	}
//
//	
//	// self made parameters insted of VaccineInventory
//	@Override
//	public VaccineInventory addVaccineCount(Vaccine inv,Integer Quantity) throws VaccineInventoryException {
//		
//		Optional<Vaccine> vi = vr.findById(inv.getVaccineId());
//		if(vi.isPresent()) {
////			vi.get().setVaccineCount.(vi.get().getVaccineCount().getQuantity()+Quantity);
//			Vaccine v=vi.get();
//			v.getVaccineInventory().getVaccineCount().setQuantity(v.getVaccineInventory().getVaccineCount().getQuantity()+Quantity);
//			vr.save(v);
//			return v.getVaccineInventory();
//		}else {
//			throw new VaccineInventoryException("no VaccineInventory found with centerId");
//		}
//	}
//
//	@Override
//	public VaccineInventory updateVaccineinventory(Vaccine inv) throws VaccineInventoryException {
//		// TODO Auto-generated method stub
//		
//		Optional<Vaccine> vi = vr.findById(inv.getVaccineId());
//		if(vi.isPresent()) {
//			
//			Vaccine v=vi.get();
//			v.getVaccineInventory().setDate(LocalDate.now());
//			v.getVaccineInventory().setVaccineCount(inv.getVaccineInventory().getVaccineCount());
//			vr.save(v);
//			return v.getVaccineInventory();
//			
//		}else {
//			throw new VaccineInventoryException("no VaccineInventory found this vaccine center");
//		}
//		
//	}
//
//	@Override
//	public boolean deleteVaccinelnventory(Vaccine inv) throws VaccineInventoryException {
//		// TODO Auto-generated method stub
//		Optional<Vaccine> vi = vr.findById(inv.getVaccineId());
//		if(vi.isPresent()) {
//			
//			Vaccine v=vi.get();
//			v.setVaccineInventory(null);
//			vr.save(v);
//			return true;
////			vr.deleteById(vi.get().getVaccineId());
//			
//		}else {
//			throw new VaccineInventoryException("no VaccineInventory found this vaccine center");
//		}
//		
//		
//	}
//
//	@Override
//	public List<Vaccine> getVaccineinventoryByDate(LocalDate date) throws VaccineInventoryException {
//		// TODO Auto-generated method stub
//		List<Vaccine> lvi = new ArrayList<>();
//		
//		List<VaccinationCenter> lvi2=vir.findAll();
//		
//		if(lvi2.size()>0) {
//			
//			for(VaccinationCenter v:lvi2) {
//				
//				if(v.getVaccines().getVaccineInventory().getDate()==date) {
//					lvi.add(v.getVaccines());
//				}
//			}
//			if(lvi.size()>0) {
//				return lvi;
//			}
//			else {
//				throw new VaccineInventoryException("no VaccineInventory found for date"+date);
//			}
//		} 
//		else {
//			throw new VaccineInventoryException("no VaccineInventory found for date"+date);
//		}
//		
//		
//		
//	}
//
//	@Override
//	public List<VaccineInventory> getVaccineinventoryByVaccine(Vaccine vaccine) throws VaccineInventoryException {
//		// TODO Auto-generated method stub
//		List<Vaccine> vl=vr.getVaccinesrByName(vaccine.getVaccninName());
//		if(vl.size()>0) {
//			List<VaccineInventory> vi= new ArrayList<>();
//			for(Vaccine v:vl) {
//				if(v.getVaccineInventory()!=null) {					
//					vi.add(v.getVaccineInventory());
//				}
//			}
//			return vi;
//		}else {
//			throw new VaccineInventoryException("no VaccineInventory found for vaccine"+vaccine.getVaccninName());
//		}
//		
//	}
//
//	@Override
//	public List<VaccineInventory> allVaccineInventory() throws VaccineInventoryException {
//		// TODO Auto-generated method stub
//		List<VaccineInventory> vi= new ArrayList<>();
//		List<Vaccine> v=vr.findAll();
//		
//		if(vi.size()>0) {
//			for(Vaccine va:v) {
//				if(va.getVaccineInventory()!= null) {
//					vi.add(va.getVaccineInventory());
//				}
//			}
//			
//			return vi;
//		}else {
//			throw new VaccineInventoryException("no VaccineInventory found ");	
//		}
//		
//		
//		
//	}
//
//	

}
