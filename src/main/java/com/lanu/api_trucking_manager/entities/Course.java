package com.lanu.api_trucking_manager.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    private String name;

    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
                fetch = FetchType.EAGER)
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList;

    public void addStudent(Student student){
        if (studentList == null){
            studentList = new ArrayList<>();
        }
        studentList.add(student);
    }
}
