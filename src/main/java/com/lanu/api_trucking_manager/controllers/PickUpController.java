package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Delivery;
import com.lanu.api_trucking_manager.entities.PickUp;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.services.PickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pickups")
public class PickUpController {

    @Autowired
    private PickUpService pickUpService;

    @PostMapping("/{pickupId}/deliveries")
    public PickUp createDelivery(@PathVariable(value = "pickupId")Integer pickupId,
                                 @Valid @RequestBody Delivery delivery){
        return pickUpService.findById(pickupId).map(pickUp -> {
            pickUp.addDelivery(delivery);
            return pickUpService.save(pickUp);
        }).orElseThrow(() -> new ResourceNotFoundException("PickUpId " + pickupId + " not found"));
    }
}
