package com.example.schooldatabase.service;

import com.example.schooldatabase.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Optional<Student> getStudentById(Long id);
}
