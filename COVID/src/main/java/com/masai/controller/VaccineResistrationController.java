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

import com.masai.exception.VaccineRgistrationException;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;
import com.masai.services.VaccinationRegistrationService;

public class VaccineResistrationController {

	@Autowired
    VaccinationRegistrationService registrationService;
	
	// Vaccine Resistration service
	
	
//		@GetMapping("/Allregistrations")
//		public ResponseEntity<List<VaccineRegistration>> getallRegistration() throws VaccineRgistrationException{
//		   	 
//		 List<VaccineRegistration> allreg= registrationService.allVaccineRegistrations();
//							   	        
//			 return new ResponseEntity<List<VaccineRegistration>>(allreg, HttpStatus.OK);
//			 
//							   	        
//		}
//		
//		@GetMapping("/member/{mobileNumber}")
//		public ResponseEntity<List<Member>> getAllMemberByNum(@PathVariable("mobileNumber") long mobileNumber) throws VaccineRgistrationException{
//			 
//			    return new ResponseEntity<List<Member>>(registrationService.getAllMember(mobileNumber),HttpStatus.OK);
//		}
//		
//		
//		 @PostMapping("/registration")
//		  public ResponseEntity<VaccineRegistration> addRegistration(@RequestBody Member mb, @RequestBody VaccineRegistration registration) throws VaccineRgistrationException{
//			   
//			      return new ResponseEntity<VaccineRegistration>(registrationService.addVaccineRegistration(mb,registration), HttpStatus.OK);
//		  }
//		 
//		 @GetMapping("/registrations/{mobileNumber}")
//		 public ResponseEntity<List<VaccineRegistration>> getVaccineRegistration( @PathVariable("mobileNumber") long mobileNumber) throws VaccineRgistrationException{
//			  
//			    return new ResponseEntity<List<VaccineRegistration>>(registrationService.getVaccineRegistration(mobileNumber),HttpStatus.OK);
//		 }
//		 
//		 @PutMapping("/registration")
//		 public ResponseEntity<VaccineRegistration> UpdateRegistration(@RequestBody Member mb, @RequestBody VaccineRegistration registration) throws VaccineRgistrationException{
//			  
//			      return new ResponseEntity<VaccineRegistration>(registrationService.updateVaccineRegistration(mb,registration),HttpStatus.OK);
//		 }
//		 
//		 @DeleteMapping("/registration")
//		 public boolean DeleteRegistraion(@RequestBody Member mb) throws VaccineRgistrationException{
//			        
//			      boolean deleted=registrationService.deleteVaccineRegistration(mb);
//			              
//			      return deleted;
//		 }
//		
			
}
