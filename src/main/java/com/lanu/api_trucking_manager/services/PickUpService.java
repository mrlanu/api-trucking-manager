package com.lanu.api_trucking_manager.services;

import com.lanu.api_trucking_manager.entities.freights.Delivery;
import com.lanu.api_trucking_manager.entities.freights.PickUp;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PickUpService {
    PickUp findByPickupId(Integer id);
    Page<PickUp> findByFreightFreightId(Long freightId, Pageable pageable);
    List<PickUp> findAllByFreightFreightId(Long freightId);
    PickUp savePickUp(PickUp pickUp);
    Optional<PickUp> findById(Integer partialId);
    PickUp saveDelivery(Integer pickupId, Delivery delivery) throws ResourceNotFoundException;
}
