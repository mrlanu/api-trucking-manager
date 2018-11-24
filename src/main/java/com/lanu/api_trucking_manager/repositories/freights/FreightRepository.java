package com.lanu.api_trucking_manager.repositories.freights;

import com.lanu.api_trucking_manager.entities.freights.Freight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreightRepository extends JpaRepository<Freight, Long> {
    Freight findByFreightId(Long id);
}
