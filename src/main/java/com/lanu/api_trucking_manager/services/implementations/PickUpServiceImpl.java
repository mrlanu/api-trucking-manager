package com.lanu.api_trucking_manager.services.implementations;

import com.lanu.api_trucking_manager.entities.PickUp;
import com.lanu.api_trucking_manager.repositories.PickUpRepository;
import com.lanu.api_trucking_manager.services.PickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickUpServiceImpl implements PickUpService {

    @Autowired
    private PickUpRepository pickUpRepository;

    @Override
    public PickUp findByPickupId(Integer id) {
        return pickUpRepository.findByPickupId(id);
    }

    @Override
    public Optional<PickUp> findById(Integer pickUpId) {
        return pickUpRepository.findById(pickUpId);
    }

    @Override
    public Page<PickUp> findByFreightFreightId(Long freightId, Pageable pageable) {
        return pickUpRepository.findByFreightFreightId(freightId, pageable);
    }

    @Override
    public List<PickUp> findAllByFreightFreightId(Long freightId) {
        return pickUpRepository.findAllByFreightFreightId(freightId);
    }

    @Override
    public PickUp save(PickUp pickUp) {
        return pickUpRepository.save(pickUp);
    }
}
