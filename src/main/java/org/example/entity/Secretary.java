package org.example.entity;

import org.example.entity.impl.GroupImpl;

import java.util.List;

public interface Secretary {
    Group createGroup(String name);
    boolean removeGroup(Group groupeToRemove);
    List<Student> getStudentsFromGroup(Group groupImpl);
    List<Student> getStudentsFromCourse(int course);
    void addStudentToGroup(Student student, Group newGroup);

}
