package org.example.entity.impl;

import org.example.entity.Group;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.exception.CustomException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherImpl implements Teacher {
    @Override
    public List<Student> getStudentsFromGroup(List<Group> groups, Group group) {
        List<Group> groupList = List.copyOf(groups);

        for (Group currentGroup : groupList) {
            if (currentGroup.equals(group)) {
                return currentGroup.getStudents();
            }
        }
        throw new CustomException("Group doesn't exists");
    }

    @Override
    public Map<Student, Group> getStudentsByFullName(List<Group> groups, String fullName) {
        Map<Student, Group> result = new HashMap<>();
        List<Group> groupList = List.copyOf(groups);

        for (Group group : groupList) {
            List<Student> students = group.getStudents();
            for (Student student : students) {
                if (student.getFullName().equals(fullName)) {
                    result.put(student, group);
                }
            }
        }
        return result;
    }
}
