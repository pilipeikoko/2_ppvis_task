package org.example.entity;

import java.util.List;

public interface Secretary {
    Group createGroup(String name);
    boolean removeGroup(List<Group> groups, Group groupeToRemove);
    List<Student> getStudentsFromGroup(List<Group> groups,Group group);
    List<Student> getStudentsFromCourse(List<Group> groups,int course);
    boolean addStudentToGroup(List<Group> groups,Student student,Group newGroup);

}
