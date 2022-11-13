package com.masai.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;
    //keeping as identifier
    private String centerName;
    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointment;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vaccinationCenter")
    private Vaccine vaccines;

    
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



    public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public Vaccine getVaccines() {
		return vaccines;
	}

	public void setVaccines(Vaccine vaccines) {
		this.vaccines = vaccines;
	}

	public VaccinationCenter() {
    }

	public VaccinationCenter(Integer code, String centerName, Address address, List<Appointment> appointment,
			Vaccine vaccines) {
		super();
		this.code = code;
		this.centerName = centerName;
		this.address = address;
		this.appointment = appointment;
		this.vaccines = vaccines;
	}

	@Override
	public String toString() {
		return "VaccinationCenter [code=" + code + ", centerName=" + centerName + ", address=" + address
				+ ", appointment=" + appointment + ""
						+ ", vaccines=" + vaccines 
						+ "]";
	}

	

}
