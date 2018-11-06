package com.lanu.api_trucking_manager.services.implementations;

import com.lanu.api_trucking_manager.entities.Freight;
import com.lanu.api_trucking_manager.repositories.FreightRepository;
import com.lanu.api_trucking_manager.services.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightRepository freightRepository;

    @Override
    public Freight findByFreightId(Long id) {
        return freightRepository.findByFreightId(id);
    }

    @Override
    public Freight save(Freight freight) {
        return freightRepository.save(freight);
    }

    @Override
    public Page<Freight> findAll(Pageable pageable) {
        return freightRepository.findAll(pageable);
    }

    @Override
    public void delete(Freight freight) {
        freightRepository.delete(freight);
    }

    @Override
    public Optional<Freight> findById(Long id) {
        return freightRepository.findById(id);
    }
}
