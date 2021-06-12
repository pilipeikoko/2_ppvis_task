package org.example.entity.impl;

import org.example.entity.Dean;
import org.example.entity.Group;
import org.example.entity.Student;
import org.example.exception.CustomException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeanImpl implements Dean {
    @Override
    public boolean changeStatus(List<Group> groups, Student student, boolean newStatus) {
        groups = Collections.synchronizedList(groups);
        synchronized (groups) {
            if (student.isStudying() &&) {
                removeStudentFromGroup(groups, student);
            }
        }
    }

    @Override
    public Map<Student, Group> getStudentsFromCity(List<Group> groups, String city) {
        List<Group> groupList = List.copyOf(groups);
        Map<Student, Group> result = new HashMap<>();

        for (Group group : groupList) {
            List<Student> students = List.copyOf(group.getStudents());

            for (Student student : students) {
                if (student.getCity().equals(city)) {
                    result.put(student, group);
                }
            }
        }

        return result;
    }

    @Override
    public boolean moveStudentToOtherGroup(List<Group> groups, Student student, Group newGroup) {
        if(student.isStudying()){
            if(removeStudentFromGroup(groups,student)){
                addStudentToNewGroup(groups,student,newGroup);
            }
            else{
                throw new CustomException("Student not found!");
            }
        }
        return true;
    }

    private void addStudentToNewGroup(List<Group> groups, Student student, Group newGroup) {
        for(Group group: groups){
            if(group.equals(newGroup)){
                group.addStudent(student);
                return;
            }
        }
        throw new CustomException("No such group!");
    }

    private boolean removeStudentFromGroup(List<Group> groups, Student student) {
        for(Group group:groups){
            List<Student> students = group.getStudents();

            for(Student currentStudent: students){
                if(currentStudent.equals(student)){
                    students.remove(currentStudent);
                    return true;
                }
            }
        }
        return false;
    }
}
