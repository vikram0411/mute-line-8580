package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Member;
import com.masai.model.Vaccine;

public interface VaccineRepo  extends JpaRepository<Vaccine, Integer>{

	//for inventory
	@Query("select v from Vaccine v where vaccninName=?1 ")
	public List<Vaccine> getVaccinesrByName(String vaccineName);
	
	//for vaccine
	@Query("select v from Vaccine v where vaccninName=?1 ")
	public Vaccine getVaccinerByName(String vaccineName);
}
