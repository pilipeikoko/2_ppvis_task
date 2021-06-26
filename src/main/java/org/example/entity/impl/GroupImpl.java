package org.example.entity.impl;

import org.example.entity.Group;
import org.example.entity.Student;
import org.example.validator.CustomValidator;
import org.example.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class GroupImpl implements Group {
    private final List<Student> students;
    private int courseNumber;
    private String name;

    {
        students = new ArrayList<>();
    }

    public GroupImpl(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void addStudent(Student student) {
        if (!CustomValidator.isStudentAlreadyInGroup(this, student.getFullName())) {
            student.setStudying(true);
            students.add(student);
        } else {
            throw new CustomException("Student with such name is already in group!");
        }
    }

    public void removeStudent(Student student) {
        if (!students.remove(student)) {
            throw new CustomException("No such student");
        }
        student.setStudying(false);
    }
}
