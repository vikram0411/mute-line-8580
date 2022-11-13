package com.masai.model;

import java.time.LocalDate;

public class ShowAppointment {
    
	 private Integer memberId;
	private Integer bookingId;
    private long mobileNo;
    private LocalDate dateOfBooking;
    private Slot slot;
    private boolean bookingStatus;
    
    public ShowAppointment() {
		// TODO Auto-generated constructor stub
	}

	public ShowAppointment(Integer memberId, Integer bookingId, long mobileNo, LocalDate dateOfBooking, Slot slot,
			boolean bookingStatus) {
		super();
		this.memberId = memberId;
		this.bookingId = bookingId;
		this.mobileNo = mobileNo;
		this.dateOfBooking = dateOfBooking;
		this.slot = slot;
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "ShowAppointment [memberId=" + memberId + ", bookingId=" + bookingId + ", mobileNo=" + mobileNo
				+ ", dateOfBooking=" + dateOfBooking + ", slot=" + slot + ", bookingStatus=" + bookingStatus + "]";
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

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
    
    
     
	
}
