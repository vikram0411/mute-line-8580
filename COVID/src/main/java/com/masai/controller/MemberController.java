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
		public Member addMember( @RequestBody Member mb) throws MemberException {
			
			Member ad =  mService.addMember(mb);
			
			return ad  ;
		}
		
		@GetMapping("/allMembers")
		public ResponseEntity<List<Member>> allMember()throws MemberException {

			List<Member> mb = mService.allMember();
			return new ResponseEntity<>(mb,HttpStatus.ACCEPTED);
		}
//		
		@GetMapping("/MemberById/{id}")
		public ResponseEntity<Member> FindByIdHandler(@PathVariable Integer id) throws MemberException{
			
		Member member=	mService.getMemberByld(id);
		return new ResponseEntity<Member>(member,HttpStatus.FOUND);
		
			
		}

//		dikkat:done 
		@GetMapping("/MemberByAdhar/{AdharNo}")
		public ResponseEntity<Member> FindByAdharMemberHandler(@PathVariable String AdharNo) throws MemberException{
			
		Member member=	mService.getMemberByAdharNo(AdharNo);
		return new ResponseEntity<Member>(member,HttpStatus.FOUND);
		
			
		}
//		
//		
		
		@GetMapping("/MemberByPan/{PanNo}")
		public ResponseEntity<Member> FindByPanMemberHandler(@PathVariable String PanNo) throws MemberException{
			
		Member member=	mService.getMemberByPanNo(PanNo);
		return new ResponseEntity<Member>(member,HttpStatus.FOUND);
		
			
		}
//		
		@PutMapping("/Member")
		public ResponseEntity<Member> UpdateMemberHandler(@RequestBody Member member) throws MemberException{
			Member memb=mService.updateMember(member);
			
			return new ResponseEntity<Member>(memb,HttpStatus.FOUND);
		}
//		
		/// changes possible :- runs but thinking of changing parameter to something easy
		@DeleteMapping("/deleteMember")
		public ResponseEntity<String> deleteMember(@RequestBody Member mb)throws MemberException{

			boolean ans = mService.deleteMember(mb) ;

			 return new ResponseEntity<String>("Member Deleted succesfully", HttpStatus.GONE) ;
		}
}
