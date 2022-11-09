package com.masai.services;

import java.util.List;

public interface VaccinationCenterService {
    
	public List<VaccinationCenter> allVaccineCenters();
	
	public VaccinationCenter getVaccineCenter (Integer centerid); 

	public VaccinationCenter QaddVaccineCenter (VaccinationCenter center);

	public VaccinationCenter updateVaccineCenter (VaccinationCenter center);

	boolean deleteVaccineCenter (VaccinationCenter center ); 	
}
