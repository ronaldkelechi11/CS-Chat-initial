package com.bms.cs.classes;

import java.util.ArrayList;

public class Group {
    String GroupName;
    String Description;
    ArrayList GroupMembers;


    public Group(String groupName, String description, ArrayList groupMembers) {
        GroupName = groupName;
        Description = description;
        GroupMembers = groupMembers;
    }
}
