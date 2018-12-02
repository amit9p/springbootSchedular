package com.capitalone.spring.boot;

public class Group {

    public String GroupName;
    public String GroupCount;
    public String GroupStartPercent;
    public String GroupCompltdPercent;
    public String LatestTimeStamp;

    public Group(){}

    public Group(String groupName, String groupCount, String groupStartPercent, String groupCompltdPercent, String latestTimeStamp) {
        GroupName = groupName;
        GroupCount = groupCount;
        GroupStartPercent = groupStartPercent;
        GroupCompltdPercent = groupCompltdPercent;
        LatestTimeStamp = latestTimeStamp;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getGroupCount() {
        return GroupCount;
    }

    public void setGroupCount(String groupCount) {
        GroupCount = groupCount;
    }

    public String getGroupStartPercent() {
        return GroupStartPercent;
    }

    public void setGroupStartPercent(String groupStartPercent) {
        GroupStartPercent = groupStartPercent;
    }

    public String getGroupCompltdPercent() {
        return GroupCompltdPercent;
    }

    public void setGroupCompltdPercent(String groupCompltdPercent) {
        GroupCompltdPercent = groupCompltdPercent;
    }

    public String getLatestTimeStamp() {
        return LatestTimeStamp;
    }

    public void setLatestTimeStamp(String latestTimeStamp) {
        LatestTimeStamp = latestTimeStamp;
    }

    @Override
    public String toString() {
        return "Group{" +
                "GroupName='" + GroupName + '\'' +
                ", GroupCount='" + GroupCount + '\'' +
                ", GroupStartPercent='" + GroupStartPercent + '\'' +
                ", GroupCompltdPercent='" + GroupCompltdPercent + '\'' +
                ", LatestTimeStamp='" + LatestTimeStamp + '\'' +
                '}';
    }
}
