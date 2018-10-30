package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Freight;
import com.lanu.api_trucking_manager.services.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loads")
public class FreightController {

    @Autowired
    private FreightService freightService;

    @PostMapping
    public Freight save(@RequestBody Freight freight){
        return freightService.save(freight);
    }

    @GetMapping
    public List<Freight> findAll() {
        return freightService.findAll();
    }
}
