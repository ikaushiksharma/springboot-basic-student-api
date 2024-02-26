package com.example.assignment.resource;

import com.example.assignment.model.StudentModel;
import com.example.assignment.service.StudentService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add-student")
public class Student {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get-id/{id}")
    public StudentModel getStudentById(@PathVariable String id) throws Exception {
        return studentService.getStudentById(id);
    }
    @GetMapping("/get-university/{university}")
    public ArrayList<StudentModel> getStudentByUniversity(@PathVariable String university) throws Exception {
        return studentService.getSutdentsByUniversity(university);
    }

    @PostMapping("/create/{name}/{age}/{adhar}/{university}")
    public String createEmployee(@PathVariable String name, @PathVariable String age, @PathVariable String adhar, @PathVariable String university) {
        return studentService.createStudent(name, age,adhar,university);
    }

}
