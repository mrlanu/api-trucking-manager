package com.lanu.api_trucking_manager.services;

import com.lanu.api_trucking_manager.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findById(Long id);
    void deleteEmployee(Employee employee);
}
