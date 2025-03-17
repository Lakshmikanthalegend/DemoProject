package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentModel addStudent(StudentModel studentModel) {
        Optional<StudentModel> findByEmail = studentRepository.findByEmail(studentModel.getEmail());
        if (findByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        return studentRepository.save(studentModel);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("Student with ID " + id + " not found.");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public StudentModel updateStudent(Long id, StudentModel newStudent) {
        StudentModel student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));

        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        student.setPhone(newStudent.getPhone());

        return student; // No need to call save() due to @Transactional.
    }
}
