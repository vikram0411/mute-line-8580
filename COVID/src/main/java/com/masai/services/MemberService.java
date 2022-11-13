package com.masai.services;

import java.util.List;

import com.masai.exception.MemberException;
import com.masai.model.Member;

public interface MemberService {
    
	public List<Member> allMember()throws MemberException;
 
	public Member getMemberByld (Integer idcardid )throws MemberException;
//
	public  Member getMemberByAdharNo (String adharno )throws MemberException;

	public Member getMemberByPanNo ( String panNo)throws MemberException;

	public Member addMember(Member member )throws MemberException;
//
	public Member updateMember ( Member member )throws MemberException; 

	public boolean deleteMember (Member member)throws MemberException;
 
}

