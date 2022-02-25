package com.kanishkkikaksha.studentdata.service;

import com.kanishkkikaksha.studentdata.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();
    Student getStudent(int rollNumber);
    String addStudent(Student student);
    String updateStudent(Student student);
    String removeStudent(int rollNumber);
}
