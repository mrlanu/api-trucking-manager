package com.lanu.api_trucking_manager.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "freights")
@Data
public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long freightId;

    private Date date;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String broker;
    private String commodity;
    private double rate;
    private int weight;
    private int pallets;
    private String kind;
    private String description;

    //--> for bi-directional
    /*@JsonManagedReference
    @OneToMany(mappedBy = "freight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> taskList;*/
}
