package com.masai.services;

public interface IdCardService {

	public  IdCard getPanCardByNumber (String panNo);

	public  IdCard getAdharCardByNo (long adharno);
	
	public  IdCard addidCard ( IdCard idcard );
	
}
