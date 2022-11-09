package com.masai.services;

public interface VaccinationCenterService {

	public VaccinationCenter getVaccineCenter (Integer centerid); 

	public VaccinationCenter QaddVaccineCenter (VaccinationCenter center);

	public VaccinationCenter updateVaccineCenter (VaccinationCenter center);

	boolean deleteVaccineCenter (VaccinationCenter center ); 	
}
