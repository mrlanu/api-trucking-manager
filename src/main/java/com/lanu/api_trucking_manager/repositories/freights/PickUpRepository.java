package com.lanu.api_trucking_manager.repositories.freights;

import com.lanu.api_trucking_manager.entities.freights.PickUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PickUpRepository extends JpaRepository<PickUp, Integer> {
    PickUp findByPickupId(Integer id);
    Page<PickUp> findByFreightFreightId(Long freightId, Pageable pageable);
    List<PickUp> findAllByFreightFreightId(Long freightId);

}
