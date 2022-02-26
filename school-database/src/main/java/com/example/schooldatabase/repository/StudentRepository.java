package com.example.schooldatabase.repository;

import com.example.schooldatabase.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findAll();
    Student save(Student student);
    Student findAById(Long id);
}
