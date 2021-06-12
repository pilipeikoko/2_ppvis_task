package org.example.entity;

import java.util.List;
import java.util.Map;

public interface Dean {
    void enrollStudent(Group group,Student student);
    void deducateStudent(Group group,Student student);
    Map<Student,Group> getStudentsFromCity(List<Group> groups, String city);
    boolean moveStudentToOtherGroup(List<Group> groups,Student student,Group newGroup);
}
