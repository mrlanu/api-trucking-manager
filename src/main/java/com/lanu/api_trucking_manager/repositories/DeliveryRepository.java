package com.lanu.api_trucking_manager.repositories;

import com.lanu.api_trucking_manager.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
