package com.lanu.api_trucking_manager.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "freights")
public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer freightId;
    private String name;

    public Freight() {
    }

    public Freight(String name) {
        this.name = name;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
