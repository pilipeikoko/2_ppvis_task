package org.example.entity.impl;

import org.example.entity.Group;
import org.example.entity.Secretary;
import org.example.entity.Student;
import org.example.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class SecretaryImpl implements Secretary {
    @Override
    public synchronized Group createGroup(String name) {
        return new Group(name);
    }

    @Override
    public synchronized boolean removeGroup(List<Group> groups, Group groupeToRemove) {
        return groups.remove(groupeToRemove);
    }

    @Override
    public synchronized List<Student> getStudentsFromGroup(List<Group> groups, Group group) {
        List<Group> groupList = List.copyOf(groups);

        for (Group currentGroup : groupList) {
            if (currentGroup.equals(group)) {
                return currentGroup.getStudents();
            }
        }
        throw new CustomException("Group doesn't exists");
    }

    @Override
    public synchronized List<Student> getStudentsFromCourse(List<Group> groups, int course) {
        List<Group> groupList = List.copyOf(groups);
        List<Student> result = new ArrayList<>();

        for (Group currentGroup : groupList) {
            if (currentGroup.getCourseNumber() == course) {
                result.addAll(currentGroup.getStudents());
            }
        }
        return result;
    }

    @Override
    public synchronized void addStudentToGroup(Student student, Group newGroup) {
        newGroup.addStudent(student);
    }
}
