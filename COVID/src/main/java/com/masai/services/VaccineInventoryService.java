package com.masai.services;

import java.time.LocalDate;
import java.util.List;

public interface VaccineInventoryService {

	public  Vaccineinventory getVaccineinventoryByCenter (Integer centerid);

	public  Vaccineinventory addVaccineCount ( Vaccineinventory inv );

	public  Vaccineinventory updateVaccineinventory ( Vaccineinventory	inv); 

	public boolean deleteVVaccinelnventory ( Vaccineinventory inv );

	public List< Vaccineinventory> getVaccineinventoryByDate (LocalDate date );

	public List< Vaccineinventory> getVaccineinventoryByVaccine (Vaccine vaccine); 
	
}
