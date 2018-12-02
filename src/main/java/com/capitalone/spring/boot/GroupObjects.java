package com.capitalone.spring.boot;

import java.sql.Timestamp;

public class GroupObjects {

    public Group grp1()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Group grp1 = new Group();
        grp1.setGroupName("GRP1");
        grp1.setGroupCount("10");
        grp1.setGroupCompltdPercent("50");
        grp1.setGroupStartPercent("100");
        grp1.setLatestTimeStamp(timestamp.toString());
        return grp1;
    }


    public Group grp2()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Group grp1 = new Group();
        grp1.setGroupName("GRP2");
        grp1.setGroupCount("70");
        grp1.setGroupCompltdPercent("500");
        grp1.setGroupStartPercent("90");
        grp1.setLatestTimeStamp(timestamp.toString());
        return grp1;
    }

    public Group grp3()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Group grp1 = new Group();
        grp1.setGroupName("GRP3");
        grp1.setGroupCount("40");
        grp1.setGroupCompltdPercent("30");
        grp1.setGroupStartPercent("70");
        grp1.setLatestTimeStamp(timestamp.toString());
        return grp1;
    }


}
