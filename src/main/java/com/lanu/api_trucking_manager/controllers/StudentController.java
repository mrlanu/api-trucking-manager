package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Course;
import com.lanu.api_trucking_manager.entities.Student;
import com.lanu.api_trucking_manager.exceptions.ResourceNotFoundException;
import com.lanu.api_trucking_manager.repositories.CourseRepository;
import com.lanu.api_trucking_manager.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId){
        return studentRepository.findByStudentId(studentId);
    }

    @PostMapping("/{studentId}/courses")
    public Student addCourseToStudent(@PathVariable Integer studentId, @Valid @RequestBody Course course){
        return studentRepository.findById(studentId).map(student -> {
            student.addCourse(course);
            return studentRepository.save(student);
        }).orElseThrow(() -> new ResourceNotFoundException("StudentId " + studentId + " not found"));
    }
}
