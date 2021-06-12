package org.example.entity;

import java.util.List;
import java.util.Map;

public interface Teacher {
    List<Student> getStudentsFromGroup(List<Group> groups, Group group);
    Map<Student,Group> getStudentsByFullName(List<Group> groups, String fullName);
}
