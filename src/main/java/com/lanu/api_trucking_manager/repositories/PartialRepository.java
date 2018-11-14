package com.lanu.api_trucking_manager.repositories;

import com.lanu.api_trucking_manager.entities.Partial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartialRepository extends JpaRepository<Partial, Integer> {
    Page<Partial> findByFreightFreightId(Long freightId, Pageable pageable);

    List<Partial> findAllByFreightFreightId(Long freightId);

}
