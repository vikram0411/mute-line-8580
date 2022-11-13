package com.masai.services;

import java.util.List;

import com.masai.exception.VaccinationCentreException;
import com.masai.model.VaccinationCenter;
import com.masai.model.VaccinationCenterShow;

public interface VaccinationCenterService {
    
	public List<VaccinationCenterShow> allVaccineCenters() throws VaccinationCentreException;
	
	public VaccinationCenterShow getVaccineCenter (Integer centerid)throws VaccinationCentreException; 
//
	public VaccinationCenterShow addVaccineCenter (VaccinationCenter center)throws VaccinationCentreException;
//
	public VaccinationCenterShow updateVaccineCenter (VaccinationCenter center)throws VaccinationCentreException;
//
	boolean deleteVaccineCenter (VaccinationCenter center )throws VaccinationCentreException; 	
}
