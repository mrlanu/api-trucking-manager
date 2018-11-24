package com.lanu.api_trucking_manager.services.implementations.freights;

import com.lanu.api_trucking_manager.entities.freights.Delivery;
import com.lanu.api_trucking_manager.entities.freights.PickUp;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.freights.DeliveryRepository;
import com.lanu.api_trucking_manager.repositories.freights.PickUpRepository;
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

    @Autowired
    private DeliveryRepository deliveryRepository;

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
    public PickUp savePickUp(PickUp pickUp) {
        return pickUpRepository.save(pickUp);
    }

    @Override
    public PickUp saveDelivery(Integer pickupId, Delivery delivery) throws ResourceNotFoundException{
        // if @RequestBody Delivery delivery contains new Delivery
        if (delivery.getDeliveryId() == null){
            delivery.setFreight(this.findByPickupId(pickupId).getFreight());
            delivery = deliveryRepository.save(delivery);
        }
        Delivery finalDelivery = delivery;
        return this.findById(pickupId).map(pickUp -> {
            pickUp.addDelivery(finalDelivery);
            return this.savePickUp(pickUp);
        }).orElseThrow(() -> new ResourceNotFoundException("PickUpId " + pickupId + " not found"));
    }
}
