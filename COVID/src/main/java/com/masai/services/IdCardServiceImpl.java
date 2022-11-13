package com.masai.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.IdCardException;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.repo.MemberRepo;

@Service
public class IdCardServiceImpl implements IdCardService{
//
//	private MemberRepo mr;
//	
//	@Override
//	public IdCard getPanCardByNumber(String panNo) throws IdCardException {
//		// TODO Auto-generated method stub
//	IdCard ic =	mr.getMemberByPanNo(panNo).getIdCard();
//	if(ic!=null) {
//		return ic;
//	}
//	else {
//		throw new IdCardException("No id card found by panNo"+panNo);
//	}
//	}
//
//	
//	@Override
//	public IdCard getAdharCardByNo(String adharno) throws IdCardException {
//		// TODO Auto-generated method stub
//		IdCard ic =	mr.getMemberByAdhar(adharno).getIdCard();
//		if(ic!=null) {
//			return ic;
//		}
//		else {
//			throw new IdCardException("No id card found by AdharNo"+adharno);
//		}
//	}
//	

//	@Override
//	public IdCard addidCard(IdCard idcard) throws IdCardException {
//		// TODO Auto-generated method stub
//		Member m=mr.getMemberByAdhar(idcard.getAdharCard().getAdharNo());
//		
//		if(m==null) {
//			Member m1 = new Member();
//			m1.setIdCard(idcard);
//		    Member m2= mr.save(m1);
//		    return m2.getIdCard();
//		}
//		else {
//			throw new IdCardException("a member is already present with the adharNo on the id card");	
//		}
//		
//		
//	}

}
