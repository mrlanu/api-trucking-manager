package com.lanu.api_trucking_manager.entities.freights;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lanu.api_trucking_manager.entities.Address;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class PickUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pickupId;

    @Enumerated(EnumType.STRING)
    private Kind kind;

    public enum Kind {
        PICKUP, DELIVERY
    }

    private Date date;
    private String time;
    private Integer trailer;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.UNSCHEDULED;

    public enum Status {
        NEW, UNSCHEDULED, SCHEDULED, COMPLETED
    }

    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "freight_id")
    @JsonIgnore
    private Freight freight;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "delivery_pickup",
            joinColumns = @JoinColumn(name = "pickup_id"),
            inverseJoinColumns = @JoinColumn(name = "delivery_id"))
    private List<Delivery> deliveryList;

    public void addDelivery(Delivery delivery){
        if (deliveryList == null){
            deliveryList = new ArrayList<>();
        }
        deliveryList.add(delivery);
    }

}
