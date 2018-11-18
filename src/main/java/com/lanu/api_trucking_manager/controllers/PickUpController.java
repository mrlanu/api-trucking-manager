package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.PickUp;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.services.FreightService;
import com.lanu.api_trucking_manager.services.PickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PickUpController {
    @Autowired
    private FreightService freightService;

    @Autowired
    private PickUpService pickUpService;

    /*@GetMapping("/freights/{freightId}/partials")
    public Page<PickUp> getAllPartialsByFreightId(@PathVariable(value = "freightId") Long freightId,
                                                   Pageable pageable) {
        return pickUpService.findByFreightFreightId(freightId, pageable);
    }*/

    @GetMapping("/freights/{freightId}/pickups")
    public List<PickUp> getAllPartialsByFreightId(@PathVariable(value = "freightId") Long freightId) {
        return pickUpService.findAllByFreightFreightId(freightId);
    }

    @PostMapping("/freights/{freightId}/pickups")
    public PickUp createPartial(@PathVariable (value = "freightId") Long freightId,
                                @Valid @RequestBody PickUp pickUp) {
        return freightService.findById(freightId).map(freight -> {
            pickUp.setFreight(freight);
            return pickUpService.save(pickUp);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }

    @PutMapping("/freights/{freightId}/pickups/{pickUpId}")
    public PickUp updatePartial(@PathVariable (value = "freightId") Long freightId,
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
            return pickUpService.save(pickUp);
        }).orElseThrow(() -> new ResourceNotFoundException("pickUpId " + pickUpId + "not found"));
    }

    /*@DeleteMapping("/freights/{freightId}/tasks/{taskId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "freightId") Long freightId,
                                           @PathVariable (value = "taskId") Long taskId) {
        if(!freightRepository.existsById(freightId)) {
            throw new ResourceNotFoundException("FreightId " + freightId + " not found");
        }

        return taskRepository.findById(taskId).map(task -> {
            taskRepository.delete(task);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("taskId " + taskId + " not found"));
    }*/
}
