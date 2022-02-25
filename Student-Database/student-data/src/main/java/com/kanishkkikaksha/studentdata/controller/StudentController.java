package com.kanishkkikaksha.studentdata.controller;

import com.kanishkkikaksha.studentdata.model.Student;
import com.kanishkkikaksha.studentdata.service.StudentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("students")
    public HttpEntity<?> getStudents() {
        try {
            ResponseEntity<List<Student>> listResponseEntity = new ResponseEntity<>(this.service.getStudents(), HttpStatus.OK);
            return listResponseEntity;
        } catch (Exception exception) {
            return new ResponseEntity<String>("No student data is present.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("students")
    public HttpEntity<?> addStudent(@RequestBody Student student) {

        try {
            String responseMessage = this.service.addStudent(student);
            ResponseEntity<String> studentResponseEntity = new ResponseEntity<>(responseMessage, HttpStatus.OK);
            if (responseMessage == null) {
                throw new RuntimeException();
            }
            return studentResponseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>("Bad Request, check your request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("students/{roll}")
    public HttpEntity<?> getStudent(@PathVariable int roll) {

        try {
            ResponseEntity<Student> studentResponseEntity = new ResponseEntity<>(this.service.getStudent(roll), HttpStatus.OK);
            if (this.service.getStudent(roll) == null) {
                throw new RuntimeException();
            }
            return studentResponseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>("No student data is present.", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("students")
    public HttpEntity<?> updateStudent(@RequestBody Student student) {

        try {
            String responseMessage = this.service.updateStudent(student);
            ResponseEntity<String> studentResponseEntity = new ResponseEntity<>(responseMessage, HttpStatus.OK);
            if (responseMessage == null) {
                throw new RuntimeException();
            }
            return studentResponseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>("No student of same roll number found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("students/{roll}")
    public HttpEntity<?> removeStudent(@PathVariable int roll) {

        try {
            String responseMessage = this.service.removeStudent(roll);
            ResponseEntity<String> studentResponseEntity = new ResponseEntity<>(responseMessage, HttpStatus.OK);
            if (responseMessage == null) {
                throw new RuntimeException();
            }
            return studentResponseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>("No student data is present.", HttpStatus.NOT_FOUND);
        }
    }
}
