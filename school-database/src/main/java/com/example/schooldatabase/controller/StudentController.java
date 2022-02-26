package com.example.schooldatabase.controller;

import com.example.schooldatabase.entity.Student;
import com.example.schooldatabase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.getAllStudents();

        if(students == null) {
            return new ResponseEntity<String> ("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @PostMapping("students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        Student responseStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(responseStudent, HttpStatus.CREATED);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if(!student.isPresent()) {
            System.out.println("here");
            return new ResponseEntity<String> ("Student does not exist.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
    }

}
