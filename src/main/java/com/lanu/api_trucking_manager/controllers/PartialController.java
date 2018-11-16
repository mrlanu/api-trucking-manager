package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Partial;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.FreightRepository;
import com.lanu.api_trucking_manager.services.FreightService;
import com.lanu.api_trucking_manager.services.PartialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PartialController {
    @Autowired
    private FreightService freightService;

    @Autowired
    private PartialService partialService;

    /*@GetMapping("/freights/{freightId}/partials")
    public Page<Partial> getAllPartialsByFreightId(@PathVariable(value = "freightId") Long freightId,
                                                   Pageable pageable) {
        return partialService.findByFreightFreightId(freightId, pageable);
    }*/

    @GetMapping("/freights/{freightId}/partials")
    public List<Partial> getAllPartialsByFreightId(@PathVariable(value = "freightId") Long freightId) {
        return partialService.findAllByFreightFreightId(freightId);
    }

    @PostMapping("/freights/{freightId}/partials")
    public Partial createPartial(@PathVariable (value = "freightId") Long freightId,
                              @Valid @RequestBody Partial partial) {
        return freightService.findById(freightId).map(freight -> {
            partial.setFreight(freight);
            return partialService.save(partial);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }

    @PutMapping("/freights/{freightId}/partials/{partialId}")
    public Partial updatePartial(@PathVariable (value = "freightId") Long freightId,
                              @PathVariable (value = "partialId") Integer partialId,
                              @Valid @RequestBody Partial partialRequest) {
        if(!freightService.existById(freightId)) {
            throw new ResourceNotFoundException("FreightId " + freightId + " not found");
        }

        return partialService.findById(partialId).map(partial -> {
            partial.setAddress(partialRequest.getAddress());
            partial.setDate(partialRequest.getDate());
            partial.setDescription(partialRequest.getDescription());
            partial.setKind(partialRequest.getKind());
            partial.setLocation(partialRequest.getLocation());
            partial.setStatus(partialRequest.getStatus());
            partial.setTime(partialRequest.getTime());
            partial.setTrailer(partialRequest.getTrailer());
            return partialService.save(partial);
        }).orElseThrow(() -> new ResourceNotFoundException("partialId " + partialId + "not found"));
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
