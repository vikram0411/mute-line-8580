//package com.masai.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.masai.exception.AdminException;
//import com.masai.exception.AppointmentException;
//import com.masai.model.Appointment;
//import com.masai.services.AppointmentService;
//
//public class AdminController {
//
//
//	@Autowired
//	AppointmentService appointmentService ;
//
//	// Admin section
//
//	// Save admin details
//
//	@PostMapping("/saveAdmin")
//	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
//
//		Admin ad =  adminDao.registerAdmin(admin);
//
//
//		return new ResponseEntity<Admin>(ad , HttpStatus.ACCEPTED) ;
//	}
//
//	//update admin details
//
//	@PutMapping("/updateAdmin")
//	public ResponseEntity<Admin> UpdateAdmin(@Valid @RequestBody Admin admin) throws AdminException {
//
//		Admin ad =  adminDao.updateAdmin(admin) ;
//
//		return new ResponseEntity<Admin>(ad , HttpStatus.OK) ;
//	}
//
//	// Get admin details
//
//	@GetMapping("/{adminId}")
//	public ResponseEntity<Admin>  getAdminByAdminId(@PathVariable("adminId") Integer adminId ) throws AdminException {
//
//		Admin ad = adminDao.getAdminById(adminId);
//
//		return new ResponseEntity<Admin>(ad , HttpStatus.OK) ;
//	}
//
//	//Delete admin
//
//	@DeleteMapping("/{adminId}")
//	public ResponseEntity<Admin> deleteAdminById(@PathVariable("adminId") Integer adminId ) throws AdminException {
//
//		Admin ad =adminDao.deleteAdminById(adminId) ;
//
//		return new ResponseEntity<Admin>(ad , HttpStatus.OK) ;
//	}
//
//
//
//	// Appointment section
//
//
//	// Get list of appointments
//
//	@GetMapping("/allAppointments/{key}")
//	public ResponseEntity<List<Appointment>> getAllAppointments(@PathVariable("key") String key) throws AppointmentException {
//
//		List<Appointment> app = appointmentService.getAllAppointment(key);
//		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
//	}
//
//	//Add appointments
//
//	@PostMapping("/addAppointment/{key}")
//	public ResponseEntity<Appointment> addAppointmentOnly(@Valid @RequestBody Appointment ap,@PathVariable String key ) throws VaccineRegistrationException, MemberNotFoundException, AppointmentException {
//
//		Appointment app = appointmentService.addAppointmentTest(ap, key) ;
//		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
//	}
//
//	// add Appointment By Member Id
//
//	@PostMapping("/addAppointment/{memberId}/{key}")
//	public ResponseEntity<Appointment> addAppointmentByMemberId(@Valid @RequestBody Appointment ap ,@PathVariable Integer memberId ,@PathVariable String key ) throws VaccineRegistrationException, MemberNotFoundException, AppointmentException {
//
//		Appointment app = appointmentService.addAppointment(ap, memberId, key);
//		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
//	}
//
//	// Get Appointment By Booking Id
//
//	@GetMapping("/getAppointment/{bookingId}/{key}")
//	public ResponseEntity<Appointment> getAppointment(@PathVariable("bookingId") long bookingId ,@PathVariable("key") String key) throws AppointmentException {
//
//		Appointment app =  appointmentService.getAppointmentByBookingId(bookingId, key) ;
//
//		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
//	}
//
//	// Update Appointment
//
//	@PutMapping("/updateAppointment/{key}")
//	public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment app ,@PathVariable("key") String key ) throws AppointmentException{
//
//		Appointment app2 = appointmentService.updateAppointment(app, key) ;
//
//		return new ResponseEntity<>(app2,HttpStatus.ACCEPTED);
//	}
//
//	//Delete Appointment
//
//	@DeleteMapping("/deleteAppointment/{bookingId}/{key}")
//	public ResponseEntity<String> deleteAppointment(@PathVariable("bookingId") Long bookingId,@PathVariable("key")String key)throws AppointmentException{
//
//		boolean ans = appointmentService.deleteAppointment(bookingId, key) ;
//
//		 return new ResponseEntity<String>("Appointment Deleted succesfully", HttpStatus.GONE) ;
//	}
//
//
//
//}
