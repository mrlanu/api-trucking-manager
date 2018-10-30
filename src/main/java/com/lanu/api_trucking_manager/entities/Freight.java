package com.lanu.api_trucking_manager.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "freights")
public class Freight {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer freightId;

    private Date date;
    private Integer brokerId;
    private int employeeId;
    private int rate;
    private String commodity;
    private String kind;
    private int pallets;
    private int weight;

    public Freight() {
    }

    public Freight(Date date, Integer brokerId, Integer employeeId,
                   Integer rate, String commodity, String kind,
                   Integer pallets, Integer weight) {
        this.date = date;
        this.brokerId = brokerId;
        this.employeeId = employeeId;
        this.rate = rate;
        this.commodity = commodity;
        this.kind = kind;
        this.pallets = pallets;
        this.weight = weight;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getPallets() {
        return pallets;
    }

    public void setPallets(Integer pallets) {
        this.pallets = pallets;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Freight{" +
                "freightId=" + freightId +
                ", date=" + date +
                ", brokerId=" + brokerId +
                ", employeeId=" + employeeId +
                ", rate=" + rate +
                ", commodity='" + commodity + '\'' +
                ", kind='" + kind + '\'' +
                ", pallets=" + pallets +
                ", weight=" + weight +
                '}';
    }
}
