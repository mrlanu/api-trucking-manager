package com.lanu.api_trucking_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
                fetch = FetchType.EAGER)
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList;

    public void addCourse(Course course){
        if (courseList == null){
            courseList = new ArrayList<>();
        }
        courseList.add(course);
    }
}
