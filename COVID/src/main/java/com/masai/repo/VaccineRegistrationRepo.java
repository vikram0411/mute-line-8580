package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Member;

public interface VaccineRegistrationRepo extends JpaRepository<Member, Integer>{

	@Query("select m from Member m where mobileNo=?1 ")
	public List<Member> getMemberBymobile(long mob);
	
	
}
