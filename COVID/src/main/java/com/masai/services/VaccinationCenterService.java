package com.masai.services;

import java.util.List;

import com.masai.model.VaccinationCenter;

public interface VaccinationCenterService {
    
	public List<VaccinationCenter> allVaccineCenters();
	
	public VaccinationCenter getVaccineCenter (Integer centerid); 

	public VaccinationCenter QaddVaccineCenter (VaccinationCenter center);

	public VaccinationCenter updateVaccineCenter (VaccinationCenter center);

	boolean deleteVaccineCenter (VaccinationCenter center ); 	
}
