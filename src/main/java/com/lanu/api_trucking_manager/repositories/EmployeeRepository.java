package com.lanu.api_trucking_manager.repositories;

import com.lanu.api_trucking_manager.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
