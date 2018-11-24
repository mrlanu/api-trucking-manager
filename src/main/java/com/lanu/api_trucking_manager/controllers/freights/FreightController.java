package com.lanu.api_trucking_manager.controllers.freights;

import com.lanu.api_trucking_manager.entities.freights.Delivery;
import com.lanu.api_trucking_manager.entities.freights.Freight;
import com.lanu.api_trucking_manager.entities.freights.PickUp;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.freights.DeliveryRepository;
import com.lanu.api_trucking_manager.services.FreightService;
import com.lanu.api_trucking_manager.services.PickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/freights")
/*@CrossOrigin(origins = "*")*/
public class FreightController {

    @Autowired
    private FreightService freightService;

    @Autowired
    private PickUpService pickUpService;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @GetMapping
    public Page<Freight> getAllFreights(Pageable pageable) {
        return freightService.findAll(pageable);
    }

    @GetMapping("/{freightId}")
    public Freight getFreightById(@PathVariable Long freightId){
        return freightService.findByFreightId(freightId);
    }

    @PostMapping
    public Freight createFreight(@Valid @RequestBody Freight freight) {
        return freightService.save(freight);
    }

    @PutMapping("/{freightId}")
    public Freight updateFreight(@PathVariable Long freightId, @Valid @RequestBody Freight freightRequest) {
        return freightService.findById(freightId).map(freight -> {
            freight.setEmployee(freightRequest.getEmployee());
            freight.setBroker(freightRequest.getBroker());
            freight.setCommodity(freightRequest.getCommodity());
            freight.setDate(freightRequest.getDate());
            freight.setDescription(freightRequest.getDescription());
            freight.setKind(freightRequest.getKind());
            freight.setPallets(freightRequest.getPallets());
            freight.setRate(freightRequest.getRate());
            freight.setWeight(freightRequest.getWeight());
            return freightService.save(freight);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }

    @DeleteMapping("/{freightId}")
    public ResponseEntity<?> deleteFreight(@PathVariable Long freightId) {
        return freightService.findById(freightId).map(freight -> {
            freightService.delete(freight);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }

    @GetMapping("/{freightId}/pickups")
    public List<PickUp> getAllPickUpsByFreightId(@PathVariable(value = "freightId") Long freightId) {
        return pickUpService.findAllByFreightFreightId(freightId);
    }

    @PostMapping("/{freightId}/pickups")
    public PickUp createPickUp(@PathVariable (value = "freightId") Long freightId,
                               @Valid @RequestBody PickUp pickUp) {
        return freightService.findById(freightId).map(freight -> {
            pickUp.setFreight(freight);
            return pickUpService.savePickUp(pickUp);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }

    @PutMapping("/{freightId}/pickups/{pickUpId}")
    public PickUp updatePickUp(@PathVariable (value = "freightId") Long freightId,
                               @PathVariable (value = "pickUpId") Integer pickUpId,
                               @Valid @RequestBody PickUp pickUpRequest) {
        if(!freightService.existById(freightId)) {
            throw new ResourceNotFoundException("FreightId " + freightId + " not found");
        }

        return pickUpService.findById(pickUpId).map(pickUp -> {
            pickUp.setAddress(pickUpRequest.getAddress());
            pickUp.setDate(pickUpRequest.getDate());
            pickUp.setDescription(pickUpRequest.getDescription());
            pickUp.setKind(pickUpRequest.getKind());
            pickUp.setLocation(pickUpRequest.getLocation());
            pickUp.setStatus(pickUpRequest.getStatus());
            pickUp.setTime(pickUpRequest.getTime());
            pickUp.setTrailer(pickUpRequest.getTrailer());
            return pickUpService.savePickUp(pickUp);
        }).orElseThrow(() -> new ResourceNotFoundException("pickUpId " + pickUpId + "not found"));
    }

    @PostMapping("/{freightId}/deliveries")
    public Delivery createDelivery(@PathVariable (value = "freightId") Long freightId,
                                 @Valid @RequestBody Delivery delivery) {
        return freightService.findById(freightId).map(freight -> {
            delivery.setFreight(freight);
            return deliveryRepository.save(delivery);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }
}
