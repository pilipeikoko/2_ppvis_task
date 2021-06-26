package org.example.entity.impl;

import org.example.entity.Group;
import org.example.entity.Secretary;
import org.example.entity.Student;
import org.example.exception.CustomException;
import org.example.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

public class SecretaryImpl implements Secretary {
    @Override
    public synchronized GroupImpl createGroup(String name) {
        return new GroupImpl(name);
    }

    @Override
    public synchronized boolean removeGroup(Group groupToRemove) {
        return GroupRepository.getInstance().removeGroup(groupToRemove);
    }

    @Override
    public synchronized List<Student> getStudentsFromGroup(Group groupImpl) {
        List<Group> groupList = GroupRepository.getInstance().getGroups();

        for (Group group : groupList) {
            if (group.equals(groupImpl)) {
                return group.getStudents();
            }
        }
        throw new CustomException("Group doesn't exists");
    }

    @Override
    public synchronized List<Student> getStudentsFromCourse(int course) {
        List<Group> groupList = GroupRepository.getInstance().getGroups();
        List<Student> result = new ArrayList<>();

        for (Group group : groupList) {
            if (group.getCourseNumber() == course) {
                result.addAll(group.getStudents());
            }
        }
        return result;
    }

    @Override
    public synchronized void addStudentToGroup(Student student, Group newGroup) {
        newGroup.addStudent(student);
    }
}
