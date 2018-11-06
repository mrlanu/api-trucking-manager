package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Employee;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getAllEmployee(Pageable pageable){
       return employeeService.findAll(pageable);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId){
        return employeeService.findByEmployeeId(employeeId);
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employee){
       return employeeService.findById(employeeId).map(empl -> {
           empl.setEmail(employee.getEmail());
           empl.setFirstName(employee.getFirstName());
           empl.setSecondName(employee.getSecondName());
           empl.setOccupation(employee.getOccupation());
           empl.setSalary(employee.getSalary());
           empl.setSalaryMeasure(employee.getSalaryMeasure());
           return employeeService.save(empl);
       }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.findById(employeeId).map(employee -> {
            employeeService.deleteEmployee(employee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }
}
