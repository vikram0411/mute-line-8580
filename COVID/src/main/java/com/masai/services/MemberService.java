package com.masai.services;

import java.util.List;

public interface MemberService {
    
	public List<Member> allMember();
 
	public Member getMemberByld (Integer idcardid );

	public  Member getMemberByAdharNo (long adharno );

	public Member getMemberByPanNo ( String panNo);

	public Member addMember(Member member );

	public Member updateMember ( Member member ); 

	public boolean deleteMember (Member member); 
}

