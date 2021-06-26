package org.example.repository;

import org.example.entity.Group;
import org.example.entity.impl.GroupImpl;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    //Thread safe singleton with Initialization On-Demand Holder
    //source: https://avaldes.com/creating-a-thread-safe-singleton-class-with-examples/
    private final List<GroupImpl> groupImpls;

    private static class Holder {
        private static final GroupRepository instance = new GroupRepository();
    }

    private GroupRepository(){
        groupImpls = new ArrayList<>();
    }

    public static GroupRepository getInstance() {
        return Holder.instance;
    }

    public List<Group> getGroups() {
        return List.copyOf(groupImpls);
    }

    public boolean removeGroup(Group groupToRemove) {
        return groupImpls.remove(groupToRemove);
    }
}
