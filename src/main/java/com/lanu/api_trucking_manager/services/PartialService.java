package com.lanu.api_trucking_manager.services;

import com.lanu.api_trucking_manager.entities.Partial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PartialService {
    Page<Partial> findByFreightFreightId(Long freightId, Pageable pageable);
    List<Partial> findAllByFreightFreightId(Long freightId);
    Partial save(Partial partial);
}
