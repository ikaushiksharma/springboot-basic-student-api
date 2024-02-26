package com.example.assignment.resource;

import com.example.assignment.model.StudentModel;
import com.example.assignment.service.StudentService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class Student {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable String id) throws Exception {
        return studentService.getStudentById(id);
    }
    @GetMapping("/university/{university}")
    public ArrayList<StudentModel> getStudentByUniversity(@PathVariable String university) throws Exception {
        return studentService.getSutdentsByUniversity(university);
    }

    @PostMapping("/{name}/{age}/{adhar}/{university}")
    public String createEmployee(@PathVariable String name, @PathVariable String age, @PathVariable String adhar, @PathVariable String university) {
        return studentService.createStudent(name, age,adhar,university);
    }

}

// /student/1

// student/university/cuiet

// student/abc/12/1234/cuiet