package com.masai.services;

public interface MemberService {
	

	public Member getMemberByld (Integer idcardid );

	public  Member getMemberByAdharNo (long adharno );

	public Member getMemberByPanNo ( String panNo);

	public Member addMember(Member member );

	public Member updateMember ( Member member ); 

	public boolean deleteMember (Member member); 
}

