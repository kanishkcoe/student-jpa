package com.kanishkkikaksha.studentdata.repository.implementation;

import com.kanishkkikaksha.studentdata.model.Student;
import com.kanishkkikaksha.studentdata.repository.StudentDatasource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ListDatasource implements StudentDatasource {

    List<Student> studentList = new ArrayList<>();

    public ListDatasource() {
        this.studentList.add(new Student(1, "kanishk"));
        this.studentList.add(new Student(2, "karan"));
        this.studentList.add(new Student(3, "kunal"));
        this.studentList.add(new Student(4, "prateek"));
    }

    @Override
    public List<Student> retrieveStudents() {
        return this.studentList;
    }

    @Override
    public Student retrieveStudent(int rollNumber) {
        for (Student student : studentList) {
            if(student.getRollNumber() == rollNumber) {
                return student;
            }
        }

        return null;
    }

    @Override
    public String removeStudent(int rollNumber) {
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getRollNumber() == rollNumber) {
                Student student = studentList.get(i);
                studentList.remove(i);
                return "Student with data " + student + " is removed";
            }
        }

        return null;
    }

    @Override
    public String createStudent(Student student) {
        if(student != null) {
            studentList.add(student);
            return "Student with data " + student + "added to the list";
        }

        return null;
    }

    @Override
    public String updateStudent(Student student) {
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getRollNumber() == student.getRollNumber()) {
                studentList.remove(i);
                studentList.add(student);
                found = true;
                break;
            }
        }
        if(found) {
            return "Student updated with new data as : " + student;
        } else {
            return null;
        }
    }
}
