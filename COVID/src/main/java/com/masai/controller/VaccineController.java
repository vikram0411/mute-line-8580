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

import com.masai.exception.VaccineException;
import com.masai.model.Vaccine;
import com.masai.repo.VaccineRepo;
import com.masai.services.VaccineService;

@RestController
public class VaccineController {

	@Autowired
    VaccineService  serviceVaccine;
	
//	@Autowired
//	VaccineRepo vr;
//	
	
	
	//done
	@PutMapping("/addvaccine/{vid}")
	  public ResponseEntity<Vaccine> AddVaccine( @RequestBody Vaccine vaccine,@PathVariable Integer vid) throws VaccineException{
		  
//		return vr.save(vaccine);
		     return new ResponseEntity<Vaccine>(serviceVaccine.addVaccine(vaccine,vid),HttpStatus.CREATED);
	  }
	
	
//	done
	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> gettAllVaccine() throws VaccineException{
		
		   List<Vaccine> allvaccine= serviceVaccine.allVaccine();
		   
		   return new ResponseEntity<List<Vaccine>>(allvaccine,HttpStatus.OK);

	}
	
	
//	done
	@GetMapping("/vaccines/{vaccineName}")
	public ResponseEntity<Vaccine> getVaccineByName(  @PathVariable("vaccineName")  String vaccineName) throws VaccineException{
		
		       Vaccine vaccineByName= serviceVaccine.getVaccineByName(vaccineName);
		       
		       return new ResponseEntity<Vaccine>(vaccineByName,HttpStatus.OK);
	}
	
//	done
	@GetMapping("vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccinesById( @PathVariable("vaccineId") Integer vaccineId) throws VaccineException{
		
		  return new ResponseEntity<Vaccine>(serviceVaccine.getVaccinebyld(vaccineId),HttpStatus.OK);
	}
//
	
	//done
	@PutMapping("/UpdateVaccine")
	  public ResponseEntity<Vaccine> UpdateVaccine( @RequestBody Vaccine vaccine) throws VaccineException{
		  
		     return new ResponseEntity<Vaccine>(serviceVaccine.updateVaccine(vaccine),HttpStatus.OK);
	  }
	
//	
	@DeleteMapping("/DeleteVaccine/{id}")
	public ResponseEntity<String> DeleteVaccine(@PathVariable Integer id) throws VaccineException{
		
		boolean ans = serviceVaccine.deleteVaccine(id) ;

		 return new ResponseEntity<String>("Vaccine Deleted succesfully", HttpStatus.GONE) ;
	}
	
}
