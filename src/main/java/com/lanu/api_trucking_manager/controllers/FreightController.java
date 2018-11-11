package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Freight;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.services.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/freights")
@CrossOrigin(origins = "*")
public class FreightController {

    @Autowired
    private FreightService freightService;

    @GetMapping
    public Page<Freight> getAllFreights(Pageable pageable) {
        return freightService.findAll(pageable);
    }

    @GetMapping("/{freightId}")
    public Freight getById(@PathVariable Long freightId){
        return freightService.findByFreightId(freightId);
    }

    @PostMapping
    public Freight createFreight(@Valid @RequestBody Freight freight) {
        return freightService.save(freight);
    }

    @PutMapping("/{freightId}")
    public Freight updateFreight(@PathVariable Long freightId, @Valid @RequestBody Freight freightRequest) {
        return freightService.findById(freightId).map(freight -> {
            //freight.setName(freightRequest.getName());
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
}
