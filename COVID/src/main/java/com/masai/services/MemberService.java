package com.masai.services;

import java.util.List;

import com.masai.exception.MemberException;
import com.masai.model.Member;
import com.masai.model.MemberShow;

public interface MemberService {
    
	public List<MemberShow> allMember()throws MemberException;
 
	public MemberShow getMemberByld (Integer idcardid )throws MemberException;
//
	public  MemberShow getMemberByAdharNo (String adharno )throws MemberException;

	public MemberShow getMemberByPanNo ( String panNo)throws MemberException;

	public MemberShow addMember(Member member )throws MemberException;
//
	public MemberShow updateMember ( Member member )throws MemberException; 

	public boolean deleteMember (Integer member)throws MemberException;
 
}

