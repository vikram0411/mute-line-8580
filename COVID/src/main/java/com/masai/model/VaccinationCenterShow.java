package com.masai.model;

public class VaccinationCenterShow {

	private Integer code;
    //keeping as identifier
    private String centerName;
    private String city;
    private String state;
    private String pinCode;
    private String vaccine;
    
    
    public VaccinationCenterShow() {
		// TODO Auto-generated constructor stub
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getCenterName() {
		return centerName;
	}


	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public String getVaccine() {
		return vaccine;
	}


	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}


	public VaccinationCenterShow(Integer code, String centerName, String city, String state, String pinCode,
			String vaccine) {
		super();
		this.code = code;
		this.centerName = centerName;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.vaccine = vaccine;
	}


	@Override
	public String toString() {
		return "VaccinationCenterShow [code=" + code + ", centerName=" + centerName + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + ", vaccine=" + vaccine + "]";
	}
    
    
    
}
