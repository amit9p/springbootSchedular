package com.capitalone.spring.boot;

import java.util.List;

public interface GroupDao {

    public Group InsertWithDefaults(final Group user);
    public void update(String GroupName , String GroupCount , String GroupStartPercent ,String GroupCompltdPercent , String LatestTimeStamp);
    public void delete();
    public List<Group> findAll();

}
