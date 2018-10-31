package com.lanu.api_trucking_manager.entities;

import javax.persistence.*;

@Entity
public class MyTaski {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer myTaskiId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "freight_id")
    private Freight freight;
}
