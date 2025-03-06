package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentModel addStudent(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }
}