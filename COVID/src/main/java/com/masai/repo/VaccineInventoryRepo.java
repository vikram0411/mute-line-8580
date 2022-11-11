package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.VaccinationCenter;

public interface VaccineInventoryRepo extends JpaRepository<VaccinationCenter, Integer> {

	
	
}
