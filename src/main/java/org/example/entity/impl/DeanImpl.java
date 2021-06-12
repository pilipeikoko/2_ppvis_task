package org.example.entity.impl;

import org.example.entity.Dean;
import org.example.entity.Group;
import org.example.entity.Student;

import java.util.List;
import java.util.Map;

public class DeanImpl implements Dean {
    @Override
    public boolean changeStatus(List<Group> groups, Student student, boolean newGroup) {
        
    }

    @Override
    public Map<Student, Group> getStudentsFromCity(List<Group> groups, String city) {
        return null;
    }

    @Override
    public boolean moveStudentToOtherGroup(List<Group> groups, Student student, Group newGroup) {
        return false;
    }
}
