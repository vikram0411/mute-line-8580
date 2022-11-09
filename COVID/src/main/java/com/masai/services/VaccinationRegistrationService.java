package com.masai.services;

import java.util.List;

public interface VaccinationRegistrationService {

	public VaccineRegistration getVaccineRegistration (long mobileno); 

	public List<Member> getAllMember (long mobileno);
	
	public VaccineRegistration addVaccineRegistration (VaccineRegistration reg); 

	public VaccineRegistration updateVaccineRegistration (VaccineRegistration reg); 

	boolean deleteVaccineRegistration ( VaccineRegistration reg);
	
}
