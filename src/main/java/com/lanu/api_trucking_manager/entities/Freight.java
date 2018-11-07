package com.lanu.api_trucking_manager.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "freights")
public class Freight extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long freightId;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "freight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> taskList;


    public Freight() {
    }

    public Freight(String name) {
        this.name = name;
    }

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
