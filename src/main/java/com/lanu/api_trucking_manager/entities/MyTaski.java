package com.lanu.api_trucking_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "my_taskis")
public class MyTaski extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer myTaskiId;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "freight_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Freight freight;

    public MyTaski() {
    }

    public MyTaski(String name) {
        this.name = name;
    }

    public Integer getMyTaskiId() {
        return myTaskiId;
    }

    public void setMyTaskiId(Integer myTaskiId) {
        this.myTaskiId = myTaskiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Freight getFreight() {
        return freight;
    }

    public void setFreight(Freight freight) {
        this.freight = freight;
    }

}
