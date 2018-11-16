package com.lanu.api_trucking_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "partials")
@Data
public class Partial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partialId;

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

}
