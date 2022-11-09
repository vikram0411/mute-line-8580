package com.masai.model;

import javax.persistence.*;

@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;
    private String centerName;
    @Embedded
    private Address address;

}
