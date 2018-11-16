package com.lanu.api_trucking_manager.services;

import com.lanu.api_trucking_manager.entities.Freight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FreightService {
    Freight findByFreightId(Long id);
    boolean existById(Long id);
    Freight save(Freight freight);
    Page<Freight> findAll(Pageable pageable);
    void delete(Freight freight);
    Optional<Freight> findById(Long id);
}
