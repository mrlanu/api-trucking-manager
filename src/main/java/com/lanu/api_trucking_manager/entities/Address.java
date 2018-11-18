package com.lanu.api_trucking_manager.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zip;
}
