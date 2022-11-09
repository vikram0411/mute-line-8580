package com.masai.services;

import java.time.LocalDate;
import java.util.List;

public interface VaccineInventoryService {
    
	public List<VaccineInventory> allVaccineInventory ();
	
	public  VaccineInventory getVaccineinventoryByCenter (Integer centerid);

	public  VaccineInventory addVaccineCount ( VaccineInventory inv );

	public  VaccineInventory updateVaccineinventory ( VaccineInventory	inv); 

	public boolean deleteVVaccinelnventory ( VaccineInventory inv );

	public List< VaccineInventory> getVaccineinventoryByDate (LocalDate date );

	public List< VaccineInventory> getVaccineinventoryByVaccine (Vaccine vaccine); 
	
}
