package com.lanu.api_trucking_manager.services;

import com.lanu.api_trucking_manager.entities.Freight;

import java.util.List;

public interface FreightService {
    Freight save(Freight freight);
    List<Freight> findAll();
}
