package com.masai.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;
    private String centerName;
    @Embedded
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Appointment>appointmentList=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL )
    private List<Vaccine>vaccines=new ArrayList<>();

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public VaccinationCenter(Integer code, String centerName, Address address, List<Appointment> appointmentList, List<Vaccine> vaccines) {
        this.code = code;
        this.centerName = centerName;
        this.address = address;
        this.appointmentList = appointmentList;
        this.vaccines = vaccines;
    }

    public VaccinationCenter() {
    }

    @Override
    public String toString() {
        return "VaccinationCenter{" +
                "code=" + code +
                ", centerName='" + centerName + '\'' +
                ", address=" + address +
                ", appointmentList=" + appointmentList +
                ", vaccines=" + vaccines +
                '}';
    }
}
