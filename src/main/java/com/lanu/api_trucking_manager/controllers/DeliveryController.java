package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Delivery;
import com.lanu.api_trucking_manager.entities.PickUp;
import com.lanu.api_trucking_manager.repositories.DeliveryRepository;
import com.lanu.api_trucking_manager.services.FreightService;
import com.lanu.api_trucking_manager.services.PickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class DeliveryController {

    @Autowired
    private FreightService freightService;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private PickUpService pickUpService;

    @PostMapping("/pickups/{pickupId}/deliveries")
    public Delivery createDelivery(@PathVariable(value = "pickupId")Integer pickupId,
                                   @Valid @RequestBody Delivery delivery){
        PickUp thePickUp = pickUpService.findByPickupId(pickupId);
        delivery.setFreight(thePickUp.getFreight());
        delivery.addPickUp(thePickUp);
        return deliveryRepository.save(delivery);
    }
}
