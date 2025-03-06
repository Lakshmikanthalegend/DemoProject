// StudentController.java
package com.example.demo.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public StudentModel addStudent(@RequestBody StudentModel student) {
        return service.addStudent(student);
    }
}