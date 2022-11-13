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

import com.masai.exception.MemberException;
import com.masai.model.Member;
import com.masai.model.MemberShow;
import com.masai.repo.MemberRepo;
import com.masai.services.MemberService;


@RestController
public class MemberController {

	// Member section
	
	@Autowired
	MemberService mService ;
	
	    @GetMapping("/hii")
	    public String hii() {
	    	return "hii";
	    }
	       
		@PutMapping("/addMember")
		public MemberShow addMember( @RequestBody Member mb) throws MemberException {
			
			MemberShow ad =  mService.addMember(mb);
			
			return ad  ;
		}
		
		
		//done
		@GetMapping("/allMembers")
		public ResponseEntity<List<MemberShow>> allMember()throws MemberException {

			List<MemberShow> mb = mService.allMember();
			return new ResponseEntity<>(mb,HttpStatus.ACCEPTED);
		}
//		
		
        //done		
		@GetMapping("/MemberById/{id}")
		public ResponseEntity<MemberShow> FindByIdHandler(@PathVariable Integer id) throws MemberException{
			
		MemberShow member=	mService.getMemberByld(id);
		return new ResponseEntity<MemberShow>(member,HttpStatus.FOUND);
		
			
		}

//		dikkat:done 
		@GetMapping("/MemberByAdhar/{AdharNo}")
		public ResponseEntity<MemberShow> FindByAdharMemberHandler(@PathVariable String AdharNo) throws MemberException{
			
		MemberShow member=	mService.getMemberByAdharNo(AdharNo);
		return new ResponseEntity<MemberShow>(member,HttpStatus.FOUND);
		
			
		}
//		
//		
		
		@GetMapping("/MemberByPan/{PanNo}")
		public ResponseEntity<MemberShow> FindByPanMemberHandler(@PathVariable String PanNo) throws MemberException{
			
		MemberShow member=	mService.getMemberByPanNo(PanNo);
		return new ResponseEntity<MemberShow>(member,HttpStatus.FOUND);
		
			
		}
//		
		@PutMapping("/Member")
		public ResponseEntity<MemberShow> UpdateMemberHandler(@RequestBody Member member) throws MemberException{
			MemberShow memb=mService.updateMember(member);
			
			return new ResponseEntity<MemberShow>(memb,HttpStatus.FOUND);
		}
//		
		/// changes possible :- runs but thinking of changing parameter to something easy
		@DeleteMapping("/deleteMember")
		public ResponseEntity<String> deleteMember(@RequestBody Member mb)throws MemberException{

			boolean ans = mService.deleteMember(mb) ;

			 return new ResponseEntity<String>("Member Deleted succesfully", HttpStatus.GONE) ;
		}
}
