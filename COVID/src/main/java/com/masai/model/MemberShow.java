package com.masai.model;

import java.time.LocalDate;

public class MemberShow {

	 private Integer memberId;
	    private boolean dose1Status;
	    private boolean dose2Status;
	    private LocalDate dose1Date;
	    private LocalDate dose2Date;
	    private String name;
	    private LocalDate DOB;
	    private String gender;
	    private String city;
	    private String state;
	    private String pinCode;
	    private String panNo;
	    private String adharNo;
	    private String fingerprints;
	    private String irisScan;
	    private long mobileNo;
	    private LocalDate dateOfRegistration;
//        private Integer  appointmentId;
        
	    public MemberShow() {
			// TODO Auto-generated constructor stub
		}
        

        	
 




//
//		public Integer getAppointmentId() {
//			return appointmentId;
//		}
//
//
//
//
//
//
//
//
//
//		public void setAppointmentId(Integer appointmentId) {
//			this.appointmentId = appointmentId;
//		}









		public long getMobileNo() {
			return mobileNo;
		}





		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}





		public LocalDate getDateOfRegistration() {
			return dateOfRegistration;
		}





		public void setDateOfRegistration(LocalDate dateOfRegistration) {
			this.dateOfRegistration = dateOfRegistration;
		}

		
		

    

		@Override
		public String toString() {
			return "MemberShow [memberId=" + memberId + ", dose1Status=" + dose1Status + ", dose2Status=" + dose2Status
					+ ", dose1Date=" + dose1Date + ", dose2Date=" + dose2Date + ", name=" + name + ", DOB=" + DOB
					+ ", gender=" + gender + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + ", panNo="
					+ panNo + ", adharNo=" + adharNo + ", fingerprints=" + fingerprints + ", irisScan=" + irisScan
					+ ", mobileNo=" + mobileNo + ", dateOfRegistration=" + dateOfRegistration + "]";
		}








		public MemberShow(Integer memberId, boolean dose1Status, boolean dose2Status, LocalDate dose1Date,
				LocalDate dose2Date, String name, LocalDate dOB, String gender, String city, String state,
				String pinCode, String panNo, String adharNo, String fingerprints, String irisScan, long mobileNo,
				LocalDate dateOfRegistration, Integer appointmentId) {
			super();
			this.memberId = memberId;
			this.dose1Status = dose1Status;
			this.dose2Status = dose2Status;
			this.dose1Date = dose1Date;
			this.dose2Date = dose2Date;
			this.name = name;
			DOB = dOB;
			this.gender = gender;
			this.city = city;
			this.state = state;
			this.pinCode = pinCode;
			this.panNo = panNo;
			this.adharNo = adharNo;
			this.fingerprints = fingerprints;
			this.irisScan = irisScan;
			this.mobileNo = mobileNo;
			this.dateOfRegistration = dateOfRegistration;
//			this.appointmentId = appointmentId;
		}









		public Integer getMemberId() {
			return memberId;
		}


		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}


		public boolean isDose1Status() {
			return dose1Status;
		}


		public void setDose1Status(boolean dose1Status) {
			this.dose1Status = dose1Status;
		}


		public boolean isDose2Status() {
			return dose2Status;
		}


		public void setDose2Status(boolean dose2Status) {
			this.dose2Status = dose2Status;
		}


		public LocalDate getDose1Date() {
			return dose1Date;
		}


		public void setDose1Date(LocalDate dose1Date) {
			this.dose1Date = dose1Date;
		}


		public LocalDate getDose2Date() {
			return dose2Date;
		}


		public void setDose2Date(LocalDate dose2Date) {
			this.dose2Date = dose2Date;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public LocalDate getDOB() {
			return DOB;
		}


		public void setDOB(LocalDate dOB) {
			DOB = dOB;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
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


		public String getPanNo() {
			return panNo;
		}


		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}


		public String getAdharNo() {
			return adharNo;
		}


		public void setAdharNo(String adharNo) {
			this.adharNo = adharNo;
		}


		public String getFingerprints() {
			return fingerprints;
		}


		public void setFingerprints(String fingerprints) {
			this.fingerprints = fingerprints;
		}


		public String getIrisScan() {
			return irisScan;
		}


		public void setIrisScan(String irisScan) {
			this.irisScan = irisScan;
		}
	    
	    
	
}
