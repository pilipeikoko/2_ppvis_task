package org.example.entity;

import org.example.entity.impl.GroupImpl;

import java.util.List;
import java.util.Map;

public interface Teacher {
    List<Student> getStudentsFromGroup(Group group);
    Map<Student, Group> getStudentsByFullName(String fullName);
}
