package com.lanu.api_trucking_manager.repositories;

import com.lanu.api_trucking_manager.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByStudentId(Integer id);
}
