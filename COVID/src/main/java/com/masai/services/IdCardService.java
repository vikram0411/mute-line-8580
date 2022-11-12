package com.masai.services;

import com.masai.exception.IdCardException;
import com.masai.model.IdCard;

public interface IdCardService {

	public  IdCard getPanCardByNumber (String panNo) throws IdCardException;

	public  IdCard getAdharCardByNo (String adharno)throws IdCardException;
	
	public  IdCard addidCard ( IdCard idcard )throws IdCardException;
	
}
