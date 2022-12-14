package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.VaccinationCentreException;
import com.masai.model.VaccinationCenter;
import com.masai.model.VaccinationCenterShow;
import com.masai.repo.VaccinationCenterRepo;
import com.masai.services.VaccinationCenterService;

@RestController
public class VaccinationCenterController {

	
	@Autowired
	VaccinationCenterService vService ;
	
//	@Autowired
//	VaccinationCenterRepo vcr;
	
	// Vaccine center Service
	
	//done
		@GetMapping("/vaccinationCenters")
		public ResponseEntity<List<VaccinationCenterShow>> getVaccineCenters() throws VaccinationCentreException {
			
			return new ResponseEntity<List<VaccinationCenterShow>>(vService.allVaccineCenters(), HttpStatus.OK);
		}

		//done
		@PutMapping("/addVaccinationCenter")
		public ResponseEntity<VaccinationCenterShow> addVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCentreException {
//			return  vcr.save(center);
			VaccinationCenterShow v=vService.addVaccineCenter(center);
			
			return new ResponseEntity<VaccinationCenterShow>(v,HttpStatus.CREATED);
		}

//		
//		//done
		@GetMapping("/vaccinationCenter/{id}")
		public ResponseEntity<VaccinationCenterShow> getVaccineCenter(@PathVariable("id") Integer id) throws VaccinationCentreException {
			return new ResponseEntity<VaccinationCenterShow>(vService.getVaccineCenter(id), HttpStatus.FOUND);
		}
//
//		//done
		@PutMapping("/vaccination_center")
		public ResponseEntity<VaccinationCenterShow> updateVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCentreException {
			return new ResponseEntity<VaccinationCenterShow>(vService.updateVaccineCenter(center),
					HttpStatus.OK);
		}
//         
//		
//		//done
		@DeleteMapping("/deleteVaccination_center")
		public ResponseEntity<String> deleteVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCentreException {
			return new ResponseEntity<>("vaccine center deleted successfully ",
					HttpStatus.OK);
		}
}
