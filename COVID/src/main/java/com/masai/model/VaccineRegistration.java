package com.masai.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class VaccineRegistration {

    private long mobileNo;
    private LocalDate dateOfRegistration;
    
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

    public VaccineRegistration(long mobileNo, LocalDate dateOfRegistration) {
        this.mobileNo = mobileNo;
        this.dateOfRegistration = dateOfRegistration;
    }

    public VaccineRegistration() {
    }

    @Override
    public String toString() {
        return "VaccineRegistration{" +
                "mobileNo=" + mobileNo +
                ", dateOfRegistration=" + dateOfRegistration +
                '}';
    }
}
