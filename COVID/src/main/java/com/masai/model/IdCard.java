package com.masai.model;

import javax.persistence.*;
import java.time.LocalDate;


public class IdCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private LocalDate DOB;
    private String gender;
    @Embedded
    private Address address;
    @Embedded
    private PanCard panCard;
    @Embedded
    private AdharCard adharCard;
    @Embedded
    private Member member;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PanCard getPanCard() {
        return panCard;
    }

    public void setPanCard(PanCard panCard) {
        this.panCard = panCard;
    }

    public AdharCard getAdharCard() {
        return adharCard;
    }

    public void setAdharCard(AdharCard adharCard) {
        this.adharCard = adharCard;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public IdCard(Integer id, String name, LocalDate DOB, String gender, Address address, PanCard panCard, AdharCard adharCard, Member member) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
        this.panCard = panCard;
        this.adharCard = adharCard;
        this.member = member;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DOB=" + DOB +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", panCard=" + panCard +
                ", adharCard=" + adharCard +
                ", member=" + member +
                '}';
    }
}
