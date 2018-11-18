package com.lanu.api_trucking_manager.services;

import com.lanu.api_trucking_manager.entities.PickUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PickUpService {
    PickUp findByPickupId(Integer id);
    Page<PickUp> findByFreightFreightId(Long freightId, Pageable pageable);
    List<PickUp> findAllByFreightFreightId(Long freightId);
    PickUp save(PickUp pickUp);
    Optional<PickUp> findById(Integer partialId);
}
