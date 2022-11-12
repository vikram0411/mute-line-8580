package com.masai.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;
    private long mobileNo;
    private LocalDate dateOfBooking;
    private Slot slot;
    private boolean bookingStatus;
    
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Member member;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appointment")
    private VaccinationCenter vaccinationCenters;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public VaccinationCenter getVaccinationCenters() {
		return vaccinationCenters;
	}

	public void setVaccinationCenters(VaccinationCenter vaccinationCenters) {
		this.vaccinationCenters = vaccinationCenters;
	}

	public Appointment(Integer bookingId, long mobileNo, LocalDate dateOfBooking, Slot slot, boolean bookingStatus,
			Member member, VaccinationCenter vaccinationCenters) {
		super();
		this.bookingId = bookingId;
		this.mobileNo = mobileNo;
		this.dateOfBooking = dateOfBooking;
		this.slot = slot;
		this.bookingStatus = bookingStatus;
		this.member = member;
		this.vaccinationCenters = vaccinationCenters;
	}

	@Override
	public String toString() {
		return "Appointment [bookingId=" + bookingId + ", mobileNo=" + mobileNo + ", dateOfBooking=" + dateOfBooking
				+ ", slot=" + slot + ", bookingStatus=" + bookingStatus + ", member=" + member + ", vaccinationCenters="
				+ vaccinationCenters + "]";
	}


    
    
}
