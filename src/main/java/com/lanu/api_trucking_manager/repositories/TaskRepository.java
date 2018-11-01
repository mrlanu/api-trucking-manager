package com.lanu.api_trucking_manager.repositories;

import com.lanu.api_trucking_manager.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByFreightFreightId(Long freightId, Pageable pageable);
}
