package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.exception.VaccineInventoryException;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;
import com.masai.services.VaccineInventoryService;

public class VaccineInventoryController {

//	@Autowired
	VaccineInventoryService vaccineInventoryService;
//	 Vaccine Inventory service
	
	
//		@PostMapping("/addInventory/{quantity}")
//		public ResponseEntity<VaccineInventory> saveInventory(@RequestBody Vaccine inv,@PathVariable("quantity") Integer qnt) throws VaccineInventoryException {
//			
////			VaccineInventory inventory = vaccineInventoryService.addVaccineCount(inv,qnt);
//			
//			return new ResponseEntity<VaccineInventory>(inventory,HttpStatus.ACCEPTED);
//			
//		}
		
		
//		@GetMapping("/allInventory")
//		public ResponseEntity<List<VaccineInventory>> getAlInventory() throws VaccineInventoryException {
//			
//			 List<VaccineInventory> inventoryList =  vaccineInventoryService.allVaccineInventory();
//			
//			return new ResponseEntity<List<VaccineInventory>>(inventoryList,HttpStatus.ACCEPTED);
//			
//		}
//		
//		
//		@GetMapping("/getInventoryByCenterId/{id}")
//		public ResponseEntity<VaccineInventory> getInventoryByCenter(@PathVariable("id") Integer id) throws VaccineInventoryException{
//			
//			VaccineInventory inventory = vaccineInventoryService.getVaccineinventoryByCenter(id);
//			
//			return new ResponseEntity<VaccineInventory>(inventory,HttpStatus.ACCEPTED);
//			
//		}
//
//		
//		@PostMapping("/updateVaccineInventory")
//		public ResponseEntity<VaccineInventory> updateVaccineInventory(@RequestBody  Vaccine	inv) throws VaccineInventoryException{
//			
//			VaccineInventory inventory = vaccineInventoryService.updateVaccineinventory(inv);
//			
//			return new ResponseEntity<VaccineInventory>(inventory,HttpStatus.ACCEPTED);
//			
//		}
//		
//		
//		@DeleteMapping("/deleteInventoryByVaccine")
//		public ResponseEntity<Boolean> deletVaccineInventory(@RequestBody  Vaccine	inv) throws VaccineInventoryException{
//			
//			Boolean ans =  vaccineInventoryService.deleteVaccinelnventory(inv);
//			
//			return new ResponseEntity<Boolean>(ans,HttpStatus.ACCEPTED);
//			
//		}
//		
//		
//		@GetMapping("/getByDate/{date}")
//		public ResponseEntity<List<Vaccine>> getInventoryByDate(@PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) throws VaccineInventoryException{
//			
//			List<Vaccine> inv = vaccineInventoryService. getVaccineinventoryByDate(date);
//			
//			return new ResponseEntity<List<Vaccine>>(inv,HttpStatus.ACCEPTED);
//			
//		}
//		
//		@GetMapping("/getVaccineInventoryByVaccine")
//		public ResponseEntity<List<VaccineInventory>> getVaccineinventoryByVaccine(@RequestBody Vaccine vaccine) throws VaccineInventoryException{
//			
//			List<VaccineInventory> inv = vaccineInventoryService.getVaccineinventoryByVaccine(vaccine);
//			
//			return new ResponseEntity<List<VaccineInventory>>(inv,HttpStatus.ACCEPTED);
//			
//		}
//		
//		
		
}
