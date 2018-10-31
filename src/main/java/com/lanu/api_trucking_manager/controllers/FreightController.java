package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Freight;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.FreightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/freights")
public class FreightController {

    @Autowired
    private FreightRepository freightRepository;

    @GetMapping
    public Page<Freight> getAllPosts(Pageable pageable) {
        return freightRepository.findAll(pageable);
    }

    @PostMapping
    public Freight createPost(@Valid @RequestBody Freight freight) {
        return freightRepository.save(freight);
    }

    @PutMapping("/{freightId}")
    public Freight updatePost(@PathVariable Integer freightId, @Valid @RequestBody Freight freightRequest) {
        return freightRepository.findById(freightId).map(freight -> {
            freight.setName(freightRequest.getName());
            return freightRepository.save(freight);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }


    @DeleteMapping("/{freightId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer freightId) {
        return freightRepository.findById(freightId).map(freight -> {
            freightRepository.delete(freight);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }
}
