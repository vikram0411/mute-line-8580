package com.masai.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private boolean dose1Status;
    private boolean dose2Status;
    private LocalDate dose1Date;
    private LocalDate dose2Date;
    @Embedded
    private IdCard idCard;

    @ManyToOne(cascade = CascadeType.ALL)
    private Appointment appointment;

    @Embedded
    private VaccineRegistration vaccineRegistration;

    public Member() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public VaccineRegistration getVaccineRegistration() {
        return vaccineRegistration;
    }

    public void setVaccineRegistration(VaccineRegistration vaccineRegistration) {
        this.vaccineRegistration = vaccineRegistration;
    }

    public Member(Integer id, boolean dose1Status, boolean dose2Status, LocalDate dose1Date, LocalDate dose2Date, IdCard idCard, Appointment appointment, VaccineRegistration vaccineRegistration) {
        this.id = id;
        this.dose1Status = dose1Status;
        this.dose2Status = dose2Status;
        this.dose1Date = dose1Date;
        this.dose2Date = dose2Date;
        this.idCard = idCard;
        this.appointment = appointment;
        this.vaccineRegistration = vaccineRegistration;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", dose1Status=" + dose1Status +
                ", dose2Status=" + dose2Status +
                ", dose1Date=" + dose1Date +
                ", dose2Date=" + dose2Date +
                ", idCard=" + idCard +
                ", appointment=" + appointment +
                ", vaccineRegistration=" + vaccineRegistration +
                '}';
    }
}
