package com.masai.model;

import javax.persistence.*;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer vaccineId;
    private String vaccninName;
    private String description;

    @Embedded
    private VaccineInventory vaccineInventory;

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccninName() {
        return vaccninName;
    }

    public void setVaccninName(String vaccninName) {
        this.vaccninName = vaccninName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VaccineInventory getVaccineInventory() {
        return vaccineInventory;
    }

    public void setVaccineInventory(VaccineInventory vaccineInventory) {
        this.vaccineInventory = vaccineInventory;
    }


    public Vaccine(Integer vaccineId, String vaccninName, String description, VaccineInventory vaccineInventory) {
        this.vaccineId = vaccineId;
        this.vaccninName = vaccninName;
        this.description = description;
        this.vaccineInventory = vaccineInventory;
    }

    public Vaccine() {
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "vaccineId=" + vaccineId +
                ", vaccninName='" + vaccninName + '\'' +
                ", description='" + description + '\'' +
                ", vaccineInventory=" + vaccineInventory +
                '}';
    }
}
