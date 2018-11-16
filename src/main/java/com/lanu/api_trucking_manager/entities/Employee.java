package com.lanu.api_trucking_manager.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    public enum Occupation {Driver, Dispatcher, Accounter, Mechanik}

    private double salary;
    private String salaryMeasure;
}
