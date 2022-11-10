package com.masai.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;
    private long mobileNo;
    private LocalDate dateOfBooking;
    private Slot slot;
    private boolean bookingStatus;

    @OneToMany
    private List<Member>memberList=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<VaccinationCenter>vaccinationCenters=new ArrayList<>();


    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
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

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<VaccinationCenter> getVaccinationCenters() {
        return vaccinationCenters;
    }

    public void setVaccinationCenters(List<VaccinationCenter> vaccinationCenters) {
        this.vaccinationCenters = vaccinationCenters;
    }

    public Appointment(long bookingId, long mobileNo, LocalDate dateOfBooking, Slot slot, boolean bookingStatus, List<Member> memberList, List<VaccinationCenter> vaccinationCenters) {
        this.bookingId = bookingId;
        this.mobileNo = mobileNo;
        this.dateOfBooking = dateOfBooking;
        this.slot = slot;
        this.bookingStatus = bookingStatus;
        this.memberList = memberList;
        this.vaccinationCenters = vaccinationCenters;
    }

    public Appointment() {
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "bookingId=" + bookingId +
                ", mobileNo=" + mobileNo +
                ", dateOfBooking=" + dateOfBooking +
                ", slot=" + slot +
                ", bookingStatus=" + bookingStatus +
                ", memberList=" + memberList +
                ", vaccinationCenters=" + vaccinationCenters +
                '}';
    }
}
