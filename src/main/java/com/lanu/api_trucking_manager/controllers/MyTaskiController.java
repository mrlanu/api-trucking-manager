package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.MyTaski;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.FreightRepository;
import com.lanu.api_trucking_manager.repositories.MyTaskiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MyTaskiController {

    @Autowired
    private FreightRepository freightRepository;

    @Autowired
    private MyTaskiRepository myTaskiRepository;

    @GetMapping("/freights/{freightId}/mytaskis")
    public Page<MyTaski> getAllMyTaskisByFreightId(@PathVariable(value = "freightId") Integer freightId,
                                                Pageable pageable) {
        return myTaskiRepository.findByFreightFreightId(freightId, pageable);
    }

    @PostMapping("/freights/{freightId}/mytaskis")
    public MyTaski createMyTaski(@PathVariable (value = "freightId") Integer freightId,
                                 @Valid @RequestBody MyTaski myTaski) {
        return freightRepository.findById(freightId).map(freight -> {
            myTaski.setFreight(freight);
            return myTaskiRepository.save(myTaski);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }

    @PutMapping("/freights/{freightId}/mytaskis/{myTaskiId}")
    public MyTaski updateComment(@PathVariable (value = "freightId") Integer freightId,
                                 @PathVariable (value = "myTaskitId") Integer myTaskiId,
                                 @Valid @RequestBody MyTaski myTaskiRequest) {
        if(!freightRepository.existsById(freightId)) {
            throw new ResourceNotFoundException("FreightId " + freightId + " not found");
        }

        return myTaskiRepository.findById(myTaskiId).map(myTaski -> {
            myTaski.setName(myTaskiRequest.getName());
            return myTaskiRepository.save(myTaski);
        }).orElseThrow(() -> new ResourceNotFoundException("MyTaskiId " + myTaskiId + "not found"));
    }

    @DeleteMapping("/freights/{freightId}/mytaskis/{mytaskiId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "freightId") Integer freightId,
                                           @PathVariable (value = "myTaskitId") Integer myTaskiId) {
        if(!freightRepository.existsById(freightId)) {
            throw new ResourceNotFoundException("FreightId " + freightId + " not found");
        }

        return myTaskiRepository.findById(myTaskiId).map(myTaski -> {
            myTaskiRepository.delete(myTaski);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("MyTaskiId " + myTaskiId + " not found"));
    }
}
