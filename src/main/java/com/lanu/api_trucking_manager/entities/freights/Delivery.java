package com.lanu.api_trucking_manager.entities.freights;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "freight_id")
    @JsonIgnore
    private Freight freight;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "delivery_pickup",
            joinColumns = @JoinColumn(name = "delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "pickup_id"))
    private List<PickUp> pickUpList;

    public void addPickUp(PickUp pickUp){
        if (pickUpList == null){
            pickUpList = new ArrayList<>();
        }
        pickUpList.add(pickUp);
    }
}
