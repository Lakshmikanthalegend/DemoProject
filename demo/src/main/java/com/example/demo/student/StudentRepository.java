package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    Optional<StudentModel> findByEmail(String email);
}