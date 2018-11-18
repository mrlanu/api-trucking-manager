package com.lanu.api_trucking_manager.controllers;

import com.lanu.api_trucking_manager.entities.Course;
import com.lanu.api_trucking_manager.repositories.CourseRepository;
import com.lanu.api_trucking_manager.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course){
        return courseRepository.save(course);
    }
}
