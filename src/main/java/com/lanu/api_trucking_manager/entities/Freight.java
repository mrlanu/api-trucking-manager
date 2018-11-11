package com.lanu.api_trucking_manager.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "freights")
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


    public Freight() {
    }


    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPallets() {
        return pallets;
    }

    public void setPallets(int pallets) {
        this.pallets = pallets;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
