package com.lanu.api_trucking_manager.controllers.freights;

import com.lanu.api_trucking_manager.entities.freights.PickUp;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.freights.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @GetMapping("/{deliveryId}/pickups")
    public List<PickUp> getAllDeliveriesByPickUp(@PathVariable(value = "deliveryId")Integer deliveryId){
        return deliveryRepository.findById(deliveryId).map(delivery -> delivery.getPickUpList()).orElseThrow(() -> new ResourceNotFoundException("PickUpId " + deliveryId + " not found"));
    }
}
