package com.example.assignment.service;

import com.example.assignment.model.StudentModel;
import com.example.assignment.repository.StudentRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    public StudentRepo studentRepo;

    public String createStudent(final String studentName, final String studentAge,final String adhar,final String university) {
        String randomId = UUID.randomUUID().toString();
        StudentModel employeeDataModel =  studentRepo.createStudent(randomId, studentName, studentAge,adhar,university);
        return employeeDataModel.getId();
    }

    public StudentModel getStudentById(final String id) throws BadRequestException {
        StudentModel employeeDataModel = studentRepo.getStudentById(id);

        if(employeeDataModel == null) {
            throw new BadRequestException("Invalid User");
        }

        return employeeDataModel;
    }
    public ArrayList<StudentModel> getSutdentsByUniversity(final String university) throws BadRequestException {
        ArrayList<StudentModel> students = studentRepo.getStudentsByUniversity(university);

        if(students == null) {
            throw new BadRequestException("Invalid Univeristy");
        }

        return students;
    }

}
