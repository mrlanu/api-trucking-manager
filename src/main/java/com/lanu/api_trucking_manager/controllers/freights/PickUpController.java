package com.lanu.api_trucking_manager.controllers.freights;

import com.lanu.api_trucking_manager.entities.freights.Delivery;
import com.lanu.api_trucking_manager.entities.freights.PickUp;
import com.lanu.api_trucking_manager.services.PickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pickups")
public class PickUpController {

    @Autowired
    private PickUpService pickUpService;

    // assigning either new or existed delivery to the particular pickUp
    @PostMapping("/{pickupId}/deliveries")
    public PickUp createDelivery(@PathVariable(value = "pickupId")Integer pickupId,
                                 @Valid @RequestBody Delivery delivery){
        return pickUpService.saveDelivery(pickupId, delivery);
    }
}
