package com.masai.services;

import java.util.List;

import com.masai.exception.VaccineException;
import com.masai.model.Vaccine;

public interface VaccineService {
    
	public List<Vaccine> allVaccine () throws VaccineException;
//	
	public Vaccine getVaccineByName(String vaccineName)throws VaccineException;  
//	
	public Vaccine getVaccinebyld (Integer vaccineld)throws VaccineException;

	public Vaccine addVaccine (Vaccine vaccine, Integer VaccinneCenterId)throws VaccineException;

	 
	
	public Vaccine updateVaccine (Vaccine vaccine)throws VaccineException;
//
	public boolean  deleteVaccine (Integer id)throws VaccineException;
	
}
