package com.masai.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer vaccineId;
    private String vaccninName;
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<VaccinationCenter>vaccinationCenters=new ArrayList<>();


    @Embedded
    private VaccineInventory vaccineInventory;

    @Embedded
    private VaccineCount vaccineCount;

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

    public List<VaccinationCenter> getVaccinationCenters() {
        return vaccinationCenters;
    }

    public void setVaccinationCenters(List<VaccinationCenter> vaccinationCenters) {
        this.vaccinationCenters = vaccinationCenters;
    }

    public VaccineInventory getVaccineInventory() {
        return vaccineInventory;
    }

    public void setVaccineInventory(VaccineInventory vaccineInventory) {
        this.vaccineInventory = vaccineInventory;
    }

    public VaccineCount getVaccineCount() {
        return vaccineCount;
    }

    public void setVaccineCount(VaccineCount vaccineCount) {
        this.vaccineCount = vaccineCount;
    }

    public Vaccine(Integer vaccineId, String vaccninName, String description, List<VaccinationCenter> vaccinationCenters, VaccineInventory vaccineInventory, VaccineCount vaccineCount) {
        this.vaccineId = vaccineId;
        this.vaccninName = vaccninName;
        this.description = description;
        this.vaccinationCenters = vaccinationCenters;
        this.vaccineInventory = vaccineInventory;
        this.vaccineCount = vaccineCount;
    }

    public Vaccine() {
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "vaccineId=" + vaccineId +
                ", vaccninName='" + vaccninName + '\'' +
                ", description='" + description + '\'' +
                ", vaccinationCenters=" + vaccinationCenters +
                ", vaccineInventory=" + vaccineInventory +
                ", vaccineCount=" + vaccineCount +
                '}';
    }
}
