package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.IdCardException;
import com.masai.model.IdCard;
import com.masai.services.IdCardService;

@RestController
public class IdCardController {

	
//	@Autowired
//	IdCardService cService ;
	
	// id card service
	
//		@PostMapping("/addIdcard")
//		public ResponseEntity<IdCard> addMember( @RequestBody IdCard idcard)throws IdCardException{
//			
//			IdCard ad =  cService.addidCard(idcard);
//			
//			return new ResponseEntity<IdCard>(ad , HttpStatus.ACCEPTED) ;
//		}
		
		
//		@GetMapping("/getPanByNumber/{PanNo}")
//		public ResponseEntity<IdCard> FindPanByNumber(@PathVariable String PanNo) throws IdCardException{
//			
//			IdCard pan=	cService.getPanCardByNumber(PanNo);
//		    return new ResponseEntity<IdCard>(pan,HttpStatus.FOUND);
//		
//			
//		}
//		
//		@GetMapping("/getAadhaarByNumber/{aadharNo}")
//		public ResponseEntity<IdCard> FindAadhaarByNumber(@PathVariable String aadharNo) throws IdCardException{
//			
//			IdCard adr=	cService.getAdharCardByNo(aadharNo);
//		    return new ResponseEntity<IdCard>(adr,HttpStatus.FOUND);
//		
			
//		}
//		
	
}
