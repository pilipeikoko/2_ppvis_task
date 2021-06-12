package org.example.entity;

import java.util.List;
import java.util.Map;

public interface Dean {
    boolean changeStatus(List<Group> groups,Student student,boolean newGroup);
    Map<Student,Group> getStudentsFromCity(List<Group> groups, String city);
    boolean moveStudentToOtherGroup(List<Group> groups,Student student,Group newGroup);
}
