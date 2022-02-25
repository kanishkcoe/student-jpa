package com.example.schooldatabase.repository;

import com.example.schooldatabase.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void shouldSaveStudent() {
        Student student = Student.builder()
                .firstName("Kanishk")
                .lastName("Debnath")
                .emailId("kanishkdebu@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    void shouldReturnAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
    }
}