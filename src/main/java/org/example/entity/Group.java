package org.example.entity;

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
}
