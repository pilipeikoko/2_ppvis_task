package org.example.repository;

import org.example.entity.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    //Singleton
    private static final GroupRepository instance = new GroupRepository();
    private final List<Group> groups;

    private GroupRepository(){
        groups = new ArrayList<>();
    }

    public static GroupRepository getInstance() {
        return instance;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
