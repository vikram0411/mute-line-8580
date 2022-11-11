package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Embedded;

public class VaccineInventory {

    private LocalDate date;

    @Embedded
    private VaccineCount vaccineCount;
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

	public VaccineCount getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(VaccineCount vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

	@Override
	public String toString() {
		return "VaccineInventory [date=" + date + ", vaccineCount=" + vaccineCount + "]";
	}

	public VaccineInventory(LocalDate date, VaccineCount vaccineCount) {
		super();
		this.date = date;
		this.vaccineCount = vaccineCount;
	}

    
    
}
