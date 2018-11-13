package com.lanu.api_trucking_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "partials")
public class Partial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partialId;

    private String kind;
    private Date date;
    private String time;
    private Integer trailer;
    private String address;
    private String description;
    private String status;
    private String location;

    @ManyToOne
    @JoinColumn(name = "freight_id")
    @JsonIgnore
    private Freight freight;

    public Partial() {
    }

    public Integer getPartialId() {
        return partialId;
    }

    public void setPartialId(Integer partialId) {
        this.partialId = partialId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTrailer() {
        return trailer;
    }

    public void setTrailer(Integer trailer) {
        this.trailer = trailer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Freight getFreight() {
        return freight;
    }

    public void setFreight(Freight freight) {
        this.freight = freight;
    }
}
