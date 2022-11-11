package com.masai.services;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.VaccineInventoryException;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;

public interface VaccineInventoryService {
    
	public List<VaccineInventory> allVaccineInventory () throws VaccineInventoryException;
	
	public  VaccineInventory getVaccineinventoryByCenter (Integer centerid) throws VaccineInventoryException;

	public  VaccineInventory addVaccineCount ( Vaccine inv ,Integer Quantity)throws VaccineInventoryException;

	public  VaccineInventory updateVaccineinventory ( Vaccine	inv)throws VaccineInventoryException; 

	public boolean deleteVaccinelnventory ( Vaccine inv )throws VaccineInventoryException;

	public List<Vaccine> getVaccineinventoryByDate (LocalDate date )throws VaccineInventoryException;

	public List< VaccineInventory> getVaccineinventoryByVaccine (Vaccine vaccine)throws VaccineInventoryException;


	
}
