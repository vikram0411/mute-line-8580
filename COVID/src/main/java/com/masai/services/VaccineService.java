package com.masai.services;

import java.util.List;

import com.masai.exception.VaccineException;
import com.masai.model.ShowVaccine;
import com.masai.model.Vaccine;

public interface VaccineService {
    
	public List<ShowVaccine> allVaccine () throws VaccineException;
//	
	public List<ShowVaccine> getVaccineByName(String vaccineName)throws VaccineException;  
//	
	public ShowVaccine getVaccinebyld (Integer vaccineld)throws VaccineException;

	public ShowVaccine addVaccine (Vaccine vaccine, Integer VaccinneCenterId)throws VaccineException;

	 
	
	public ShowVaccine updateVaccine (Vaccine vaccine)throws VaccineException;
//
	public boolean  deleteVaccine (Integer id)throws VaccineException;
	
}
