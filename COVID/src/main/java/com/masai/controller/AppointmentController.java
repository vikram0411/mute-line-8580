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

import com.masai.exception.AppointmentException;
import com.masai.exception.MemberException;
import com.masai.exception.VaccineRgistrationException;
import com.masai.model.Appointment;
import com.masai.model.Member;
import com.masai.model.ShowAppointment;
import com.masai.model.VaccinationCenter;
import com.masai.services.AppointmentService;

@RestController
public class AppointmentController {
	
	
	@Autowired
	AppointmentService appointmentService ;
	// Appointment section


		// Get list of appointments
//
		@GetMapping("/allAppointments")
		public ResponseEntity<List<ShowAppointment>> getAllAppointments() throws AppointmentException {

			List<ShowAppointment> app = appointmentService.allAppintment();
			return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
		}
//
//		//Add appointments
//
		@PutMapping("/addAppointment/{memberid}/{vc}")
		public ResponseEntity<ShowAppointment> addAppointmentOnly( @PathVariable("memberid") Integer memberid ,@PathVariable Integer vc,@RequestBody Appointment ap ) throws VaccineRgistrationException, MemberException, AppointmentException {

			ShowAppointment app = appointmentService.addAppointment(memberid,ap,vc) ;
			return new ResponseEntity<ShowAppointment>(app,HttpStatus.ACCEPTED);
		}
//
//		
//		// Get Appointment By Booking Id
//
		@GetMapping("/getAppointment/{bookingId}")
		public ResponseEntity<ShowAppointment> getAppointment(@PathVariable("bookingId") Integer bookingId ) throws AppointmentException {

			ShowAppointment app =  appointmentService.getAppointment(bookingId) ;

			return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
		}
//
//		// Update Appointment
//
		@PutMapping("/updateAppointment/{memberid}")
		public ResponseEntity<ShowAppointment> updateAppointment( @PathVariable("memberid") Integer mb ,@RequestBody Appointment ap ) throws AppointmentException{

			ShowAppointment app2 = appointmentService.updateAppointment(mb,ap) ;

			return new ResponseEntity<>(app2,HttpStatus.ACCEPTED);
		}
//
//		//Delete Appointment
//
//		@DeleteMapping("/deleteAppointment/{bookingId}")
//		public ResponseEntity<String> deleteAppointment(@RequestBody Appointment app)throws AppointmentException{
//
//			boolean ans = appointmentService.deleteAppointment(app) ;
//
//			 return new ResponseEntity<String>("Appointment Deleted succesfully", HttpStatus.GONE) ;
//		}
}
