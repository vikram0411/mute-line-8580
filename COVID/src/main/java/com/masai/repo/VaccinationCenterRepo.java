package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.VaccinationCenter;

public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer>  {

	public VaccinationCenter findByCenterName(String centerName);
	
	
}
