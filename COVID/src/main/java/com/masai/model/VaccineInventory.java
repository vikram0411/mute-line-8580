package com.masai.model;

import java.time.LocalDate;

public class VaccineInventory {

    private LocalDate date;

    private Member member;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;

        if(member.getDose1Date()==null){

            member.setDose1Date(this.date);
            member.setDose1Status(true);

        }else if(member.getDose2Date()==null){

            member.setDose2Date(this.date);
            member.setDose2Status(true);

        }else {
            throw new IllegalArgumentException("Already registered");
        }

    }

}
