package org.bsuir.task.entity.impl;

import org.bsuir.task.entity.Group;
import org.bsuir.task.entity.Secretary;
import org.bsuir.task.entity.Student;
import org.bsuir.task.exception.CustomException;
import org.bsuir.task.repository.GroupRepository;

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
