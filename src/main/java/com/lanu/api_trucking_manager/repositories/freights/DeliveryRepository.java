package com.lanu.api_trucking_manager.repositories.freights;

import com.lanu.api_trucking_manager.entities.freights.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
