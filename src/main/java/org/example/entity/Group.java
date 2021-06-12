package org.example.entity;

import org.example.entity.validator.CustomValidator;
import org.example.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private int courseNumber;
    List<Student> students;

    {
        students = new ArrayList<>();
    }

    public Group(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void addStudent(Student student) {
        if(!CustomValidator.isStudentAlreadyInGroup(this,student.getFullName())){
            students.add(student);
        }
        else{
            throw new CustomException("Student with such name is already in group!");
        }
    }

}
