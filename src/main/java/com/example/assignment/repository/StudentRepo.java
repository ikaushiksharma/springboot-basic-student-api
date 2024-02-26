package com.example.assignment.repository;

import com.example.assignment.model.StudentModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentRepo {
    private Map<String, StudentModel> studentDataMap;
    private Map<String,
            ArrayList<StudentModel>> universityDataMap;

    public StudentRepo() {
        studentDataMap = new HashMap<>();
        universityDataMap = new HashMap<>();
    }

    public StudentModel getStudentById(final String id) {
        return studentDataMap.getOrDefault(id, null);
    }

    public ArrayList<StudentModel> getStudentsByUniversity(final String university) {
        return universityDataMap.getOrDefault(university,null);
    }

    public StudentModel createStudent(final String id, final String name, final String age,final String adhar,final String university) {
        StudentModel newStudentModel = new StudentModel(id, name, age,adhar,university);
        studentDataMap.put(id, newStudentModel);
        if (!universityDataMap.containsKey(university)) {
            universityDataMap.put(university,new ArrayList<>());
        }
        universityDataMap.get(university).add(newStudentModel);
        return newStudentModel;
    }
}
