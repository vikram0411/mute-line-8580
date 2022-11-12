package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.exception.AdminException;
import com.masai.exception.AppointmentException;
import com.masai.exception.IdCardException;
import com.masai.exception.MemberException;
import com.masai.exception.VaccinationCentreException;
import com.masai.exception.VaccineException;
import com.masai.exception.VaccineInventoryException;
import com.masai.exception.VaccineRgistrationException;
import com.masai.model.Appointment;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.VaccinationCenter;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;
import com.masai.model.VaccineRegistration;
import com.masai.services.AppointmentService;
import com.masai.services.IdCardService;
import com.masai.services.MemberService;
import com.masai.services.VaccinationCenterService;
import com.masai.services.VaccinationRegistrationService;
import com.masai.services.VaccineInventoryService;
import com.masai.services.VaccineService;

public class AdminController {


	@Autowired
	AppointmentService appointmentService ;
	
	@Autowired
	MemberService mService ;
	
	@Autowired
	IdCardService cService ;
	
	@Autowired
	VaccinationCenterService vService ;
	
	@Autowired
    VaccineService  serviceVaccine;
	
	@Autowired
	VaccineInventoryService vaccineInventoryService;
	
	@Autowired
     VaccinationRegistrationService registrationService;

	

	// Appointment section


	// Get list of appointments

	@GetMapping("/allAppointments")
	public ResponseEntity<List<Appointment>> getAllAppointments() throws AppointmentException {

		List<Appointment> app = appointmentService.allAppintment();
		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
	}

	//Add appointments

	@PostMapping("/addAppointment")
	public ResponseEntity<Appointment> addAppointmentOnly( @RequestBody Appointment ap,@RequestBody Member mb ) throws VaccineRgistrationException, MemberException, AppointmentException {

		Appointment app = appointmentService.addAppointment(mb,ap) ;
		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
	}

	
	// Get Appointment By Booking Id

	@GetMapping("/getAppointment/{bookingId}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable("bookingId") Integer bookingId ) throws AppointmentException {

		Appointment app =  appointmentService.getAppointment(bookingId) ;

		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
	}

	// Update Appointment

	@PutMapping("/updateAppointment/{key}")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment app,@RequestBody Member mb) throws AppointmentException{

		Appointment app2 = appointmentService.updateAppointment(mb,app) ;

		return new ResponseEntity<>(app2,HttpStatus.ACCEPTED);
	}

	//Delete Appointment

	@DeleteMapping("/deleteAppointment/{bookingId}")
	public ResponseEntity<String> deleteAppointment(@RequestBody Appointment app)throws AppointmentException{

		boolean ans = appointmentService.deleteAppointment(app) ;

		 return new ResponseEntity<String>("Appointment Deleted succesfully", HttpStatus.GONE) ;
	}
	
	// Member section
	
	
	@PostMapping("/addMember")
	public ResponseEntity<Member> addMember( @RequestBody Member mb) throws MemberException {
		
		Member ad =  mService.addMember(mb);
		
		return new ResponseEntity<Member>(ad , HttpStatus.ACCEPTED) ;
	}
	
	@GetMapping("/allMembers")
	public ResponseEntity<List<Member>> allMember()throws MemberException {

		List<Member> mb = mService.allMember();
		return new ResponseEntity<>(mb,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/MemberById/{id}")
	public ResponseEntity<Member> FindByIdHandler(@PathVariable Integer id) throws MemberException{
		
	Member member=	mService.getMemberByld(id);
	return new ResponseEntity<Member>(member,HttpStatus.FOUND);
	
		
	}

	
	@GetMapping("/MemberByAdhar/{AdharNo}")
	public ResponseEntity<Member> FindByAdharMemberHandler(@PathVariable String AdharNo) throws MemberException{
		
	Member member=	mService.getMemberByAdharNo(AdharNo);
	return new ResponseEntity<Member>(member,HttpStatus.FOUND);
	
		
	}
	
	@GetMapping("/MemberByPan/{PanNo}")
	public ResponseEntity<Member> FindByPanMemberHandler(@PathVariable String PanNo) throws MemberException{
		
	Member member=	mService.getMemberByPanNo(PanNo);
	return new ResponseEntity<Member>(member,HttpStatus.FOUND);
	
		
	}
	
	@PutMapping("/Member")
	public ResponseEntity<Member> UpdateMemberHandler(@RequestBody Member member) throws MemberException{
		Member memb=mService.updateMember(member);
		
		return new ResponseEntity<Member>(member,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteMember")
	public ResponseEntity<String> deleteMember(@RequestBody Member mb)throws MemberException{

		boolean ans = mService.deleteMember(mb) ;

		 return new ResponseEntity<String>("Member Deleted succesfully", HttpStatus.GONE) ;
	}
	
	// id card service
	
	@PostMapping("/addIdcard")
	public ResponseEntity<IdCard> addMember( @RequestBody IdCard idcard)throws IdCardException{
		
		IdCard ad =  cService.addidCard(idcard);
		
		return new ResponseEntity<IdCard>(ad , HttpStatus.ACCEPTED) ;
	}
	
	
	@GetMapping("/getPanByNumber/{PanNo}")
	public ResponseEntity<IdCard> FindPanByNumber(@PathVariable String PanNo) throws IdCardException{
		
		IdCard pan=	cService.getPanCardByNumber(PanNo);
	    return new ResponseEntity<IdCard>(pan,HttpStatus.FOUND);
	
		
	}
	
	@GetMapping("/getAadhaarByNumber/{aadharNo}")
	public ResponseEntity<IdCard> FindAadhaarByNumber(@PathVariable String aadharNo) throws IdCardException{
		
		IdCard adr=	cService.getAdharCardByNo(aadharNo);
	    return new ResponseEntity<IdCard>(adr,HttpStatus.FOUND);
	
		
	}
	
	
	// Vaccine center Service
	
	
	@GetMapping("/vaccinationCenters")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenters() throws VaccinationCentreException {
		
		return new ResponseEntity<List<VaccinationCenter>>(vService.allVaccineCenters(), HttpStatus.OK);
	}

	@PostMapping("/vaccinationCenter")
	public ResponseEntity<VaccinationCenter> addVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCentreException {
		return new ResponseEntity<VaccinationCenter>(vService.addVaccineCenter(center),
				HttpStatus.CREATED);
	}

	@GetMapping("/vaccinationCenter/{id}")
	public ResponseEntity<VaccinationCenter> getVaccineCenter(@PathVariable("id") Integer id) throws VaccinationCentreException {
		return new ResponseEntity<VaccinationCenter>(vService.getVaccineCenter(id), HttpStatus.FOUND);
	}

	@PutMapping("/vaccination_center")
	public ResponseEntity<VaccinationCenter> updateVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCentreException {
		return new ResponseEntity<VaccinationCenter>(vService.updateVaccineCenter(center),
				HttpStatus.OK);
	}

	@DeleteMapping("/vaccination_center")
	public ResponseEntity<String> deleteVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCentreException {
		return new ResponseEntity<>("vaccine center deleted : " + vService.deleteVaccineCenter(center),
				HttpStatus.OK);
	}
	
	
	
	// Vaccine Service
	
	@PostMapping("/vaccine")
	  public ResponseEntity<Vaccine> AddVaccine( @RequestBody Vaccine vaccine) throws VaccineException{
		  
		     return new ResponseEntity<Vaccine>(serviceVaccine.addVaccine(vaccine),HttpStatus.CREATED);
	  }
	
	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> gettAllVaccine() throws VaccineException{
		
		   List<Vaccine> allvaccine= serviceVaccine.allVaccine();
		   
		   return new ResponseEntity<List<Vaccine>>(allvaccine,HttpStatus.OK);
	}
	
	@GetMapping("/vaccines/{vaccineName}")
	public ResponseEntity<Vaccine> getVaccineByName(  @PathVariable("vaccineName")  String vaccineName) throws VaccineException{
		
		       Vaccine vaccineByName= serviceVaccine.getVaccineByName(vaccineName);
		       
		       return new ResponseEntity<Vaccine>(vaccineByName,HttpStatus.OK);
	}
	
	@GetMapping("vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccinesById( @PathVariable("vaccineId") Integer vaccineId) throws VaccineException{
		
		  return new ResponseEntity<Vaccine>(serviceVaccine.getVaccinebyld(vaccineId),HttpStatus.OK);
	}

	@PutMapping("/vaccine")
	  public ResponseEntity<Vaccine> UpdateVaccine( @RequestBody Vaccine vaccine) throws VaccineException{
		  
		     return new ResponseEntity<Vaccine>(serviceVaccine.updateVaccine(vaccine),HttpStatus.OK);
	  }
	
	@DeleteMapping("/vaccine")
	public ResponseEntity<String> DeleteVaccine( @RequestBody Vaccine vaccine) throws VaccineException{
		
		boolean ans = serviceVaccine.deleteVaccine(vaccine) ;

		 return new ResponseEntity<String>("Vaccine Deleted succesfully", HttpStatus.GONE) ;
	}
	
	
	
	// Vaccine Inventory service
	
	
	@PostMapping("/addInventory/{quantity}")
	public ResponseEntity<VaccineInventory> saveInventory(@RequestBody Vaccine inv,@PathVariable("quantity") Integer qnt) throws VaccineInventoryException {
		
		VaccineInventory inventory = vaccineInventoryService.addVaccineCount(inv,qnt);
		
		return new ResponseEntity<VaccineInventory>(inventory,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/allInventory")
	public ResponseEntity<List<VaccineInventory>> getAlInventory() throws VaccineInventoryException {
		
		 List<VaccineInventory> inventoryList =  vaccineInventoryService.allVaccineInventory();
		
		return new ResponseEntity<>(inventoryList,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getInventoryByCenterId/{id}")
	public ResponseEntity<VaccineInventory> getInventoryByCenter(@PathVariable("id") Integer id) throws VaccineInventoryException{
		
		VaccineInventory inventory = vaccineInventoryService.getVaccineinventoryByCenter(id);
		
		return new ResponseEntity<VaccineInventory>(inventory,HttpStatus.ACCEPTED);
		
	}

	
	@PostMapping("/updateVaccineInventory")
	public ResponseEntity<VaccineInventory> updateVaccineInventory(@RequestBody  Vaccine	inv) throws VaccineInventoryException{
		
		VaccineInventory inventory = vaccineInventoryService.updateVaccineinventory(inv);
		
		return new ResponseEntity<VaccineInventory>(inventory,HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/deleteInventoryByVaccine")
	public ResponseEntity<Boolean> deletVaccineInventory(@RequestBody  Vaccine	inv) throws VaccineInventoryException{
		
		Boolean ans =  vaccineInventoryService.deleteVaccinelnventory(inv);
		
		return new ResponseEntity<Boolean>(ans,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getByDate/{date}")
	public ResponseEntity<List<Vaccine>> getInventoryByDate(@PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) throws VaccineInventoryException{
		
		List<Vaccine> inv = vaccineInventoryService. getVaccineinventoryByDate(date);
		
		return new ResponseEntity<List<Vaccine>>(inv,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getVaccineInventoryByVaccine")
	public ResponseEntity<List<VaccineInventory>> getVaccineinventoryByVaccine(@RequestBody Vaccine vaccine) throws VaccineInventoryException{
		
		List<VaccineInventory> inv = vaccineInventoryService.getVaccineinventoryByVaccine(vaccine);
		
		return new ResponseEntity<List<VaccineInventory>>(inv,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	// Vaccine Resistration service
	
	
	@GetMapping("/Allregistrations")
	public ResponseEntity<List<VaccineRegistration>> getallRegistration() throws VaccineRgistrationException{
	   	 
	 List<VaccineRegistration> allreg= registrationService.allVaccineRegistrations();
						   	        
		 return new ResponseEntity<List<VaccineRegistration>>(allreg, HttpStatus.OK);
		 
						   	        
	}
	
	@GetMapping("/member/{mobileNumber}")
	public ResponseEntity<List<Member>> getAllMemberByNum(@PathVariable("mobileNumber") long mobileNumber) throws VaccineRgistrationException{
		 
		    return new ResponseEntity<List<Member>>(registrationService.getAllMember(mobileNumber),HttpStatus.OK);
	}
	
	
	 @PostMapping("/registration")
	  public ResponseEntity<VaccineRegistration> addRegistration(@RequestBody Member mb, @RequestBody VaccineRegistration registration) throws VaccineRgistrationException{
		   
		      return new ResponseEntity<VaccineRegistration>(registrationService.addVaccineRegistration(mb,registration), HttpStatus.OK);
	  }
	 
	 @GetMapping("/registrations/{mobileNumber}")
	 public ResponseEntity<List<VaccineRegistration>> getVaccineRegistration( @PathVariable("mobileNumber") long mobileNumber) throws VaccineRgistrationException{
		  
		    return new ResponseEntity<List<VaccineRegistration>>(registrationService.getVaccineRegistration(mobileNumber),HttpStatus.OK);
	 }
	 
	 @PutMapping("/registration")
	 public ResponseEntity<VaccineRegistration> UpdateRegistration(@RequestBody Member mb, @RequestBody VaccineRegistration registration) throws VaccineRgistrationException{
		  
		      return new ResponseEntity<VaccineRegistration>(registrationService.updateVaccineRegistration(mb,registration),HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/registration")
	 public boolean DeleteRegistraion(@RequestBody Member mb) throws VaccineRgistrationException{
		        
		      boolean deleted=registrationService.deleteVaccineRegistration(mb);
		              
		      return deleted;
	 }
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
