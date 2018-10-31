package com.lanu.api_trucking_manager.repositories;

import com.lanu.api_trucking_manager.entities.MyTaski;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTaskiRepository extends JpaRepository<MyTaski, Integer> {
    Page<MyTaski> findByFreightFreightId(Integer freightId, Pageable pageable);
}
