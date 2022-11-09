package com.masai.services;

public interface VaccineService {

	public Vaccine getVaccineByName(String vaccineName);  
	
	public Vaccine getVaccinebyld (Integer vaccineld);

	public Vaccine addVaccine (Vaccine vaccine); 
	
	public Vaccine updateVaccine (Vaccine vaccine);

	public boolean  deleteVaccine (Vaccine vaccine);
	
}
