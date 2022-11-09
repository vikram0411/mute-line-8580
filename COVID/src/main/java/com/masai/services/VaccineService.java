package com.masai.services;

import java.util.List;

public interface VaccineService {
    
	public List<Vaccine> allVaccine ();
	
	public Vaccine getVaccineByName(String vaccineName);  
	
	public Vaccine getVaccinebyld (Integer vaccineld);

	public Vaccine addVaccine (Vaccine vaccine); 
	
	public Vaccine updateVaccine (Vaccine vaccine);

	public boolean  deleteVaccine (Vaccine vaccine);
	
}
