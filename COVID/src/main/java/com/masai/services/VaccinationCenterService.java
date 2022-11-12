package com.masai.services;

import java.util.List;

import com.masai.exception.VaccinationCentreException;
import com.masai.model.VaccinationCenter;

public interface VaccinationCenterService {
    
	public List<VaccinationCenter> allVaccineCenters() throws VaccinationCentreException;
	
	public VaccinationCenter getVaccineCenter (Integer centerid)throws VaccinationCentreException; 

	public VaccinationCenter addVaccineCenter (VaccinationCenter center)throws VaccinationCentreException;

	public VaccinationCenter updateVaccineCenter (VaccinationCenter center)throws VaccinationCentreException;

	boolean deleteVaccineCenter (VaccinationCenter center )throws VaccinationCentreException; 	
}
