package com.lanu.api_trucking_manager.services.implementations;

import com.lanu.api_trucking_manager.entities.Freight;
import com.lanu.api_trucking_manager.repositories.FreightRepository;
import com.lanu.api_trucking_manager.services.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightRepository freightRepository;

    public Freight save(Freight freight) {
        return freightRepository.save(freight);
    }

    public List<Freight> findAll() {
        return freightRepository.findAll();
    }

    @Override
    public Freight getOne(Integer id) {
        return freightRepository.getOne(id);
    }
}
