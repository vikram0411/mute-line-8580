package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {
	
	
	@Query("select m from Member m where m.idCard.adharCard.adharNo=?1 ")
	public Member getMemberByAdhar(String adharNo);
	
	@Query("select m from Member m where m.idCard.panCard.panNo=?1 ")
	public Member getMemberByPanNo(String panNo);

}
