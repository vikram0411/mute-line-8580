package com.masai.services;

import com.masai.model.IdCard;

public interface IdCardService {

	public  IdCard getPanCardByNumber (String panNo);

	public  IdCard getAdharCardByNo (long adharno);
	
	public  IdCard addidCard ( IdCard idcard );
	
}
