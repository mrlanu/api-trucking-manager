package com.lanu.api_trucking_manager.services.implementations;

import com.lanu.api_trucking_manager.entities.Employee;
import com.lanu.api_trucking_manager.repositories.EmployeeRepository;
import com.lanu.api_trucking_manager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findByEmployeeId(Long id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
