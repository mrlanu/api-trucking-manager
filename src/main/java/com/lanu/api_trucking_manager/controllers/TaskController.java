package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Task;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.FreightRepository;
import com.lanu.api_trucking_manager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TaskController {

    @Autowired
    private FreightRepository freightRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/freights/{freightId}/tasks")
    public Page<Task> getAllTasksByFreightId(@PathVariable(value = "freightId") Integer freightId,
                                             Pageable pageable) {
        return taskRepository.findByFreightFreightId(freightId, pageable);
    }

    @PostMapping("/freights/{freightId}/tasks")
    public Task createMyTaski(@PathVariable (value = "freightId") Integer freightId,
                              @Valid @RequestBody Task task) {
        return freightRepository.findById(freightId).map(freight -> {
            task.setFreight(freight);
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("FreightId " + freightId + " not found"));
    }

    @PutMapping("/freights/{freightId}/tasks/{taskId}")
    public Task updateComment(@PathVariable (value = "freightId") Integer freightId,
                              @PathVariable (value = "taskId") Integer taskId,
                              @Valid @RequestBody Task taskRequest) {
        if(!freightRepository.existsById(freightId)) {
            throw new ResourceNotFoundException("FreightId " + freightId + " not found");
        }

        return taskRepository.findById(taskId).map(task -> {
            task.setName(taskRequest.getName());
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("taskId " + taskId + "not found"));
    }

    @DeleteMapping("/freights/{freightId}/tasks/{taskId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "freightId") Integer freightId,
                                           @PathVariable (value = "taskId") Integer taskId) {
        if(!freightRepository.existsById(freightId)) {
            throw new ResourceNotFoundException("FreightId " + freightId + " not found");
        }

        return taskRepository.findById(taskId).map(task -> {
            taskRepository.delete(task);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("taskId " + taskId + " not found"));
    }
}
