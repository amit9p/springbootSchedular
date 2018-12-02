package com.capitalone.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Component
public class ScheduledTasks {

    @Autowired
    GroupDao grpDao;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");


    @Scheduled(fixedRate = 60000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
        logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        //Deleting Cache Table
        grpDao.delete();


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //Creating default group Object

        Group grp1 = new Group();
        grp1.setGroupName("GRP1");
        grp1.setGroupCount("0");
        grp1.setGroupCompltdPercent("0");
        grp1.setGroupStartPercent("0");
        grp1.setLatestTimeStamp(timestamp.toString());

        Group grp2 = new Group();
        grp2.setGroupName("GRP2");
        grp2.setGroupCount("0");
        grp2.setGroupCompltdPercent("0");
        grp2.setGroupStartPercent("0");
        grp2.setLatestTimeStamp(timestamp.toString());

        Group grp3 = new Group();
        grp3.setGroupName("GRP3");
        grp3.setGroupCount("0");
        grp3.setGroupCompltdPercent("0");
        grp3.setGroupStartPercent("0");
        grp3.setLatestTimeStamp(timestamp.toString());

        grpDao.InsertWithDefaults(grp1);
        grpDao.InsertWithDefaults(grp2);
        grpDao.InsertWithDefaults(grp3);
        logger.info("Default Values Inserted :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));


        //updating group count


        GroupObjects go = new GroupObjects();
        grpDao.update(go.grp1().getGroupName(),go.grp1().getGroupCount(), go.grp1().GroupStartPercent, go.grp1().getGroupCompltdPercent(), go.grp1().getLatestTimeStamp());

        grpDao.update(go.grp2().getGroupName(),go.grp2().getGroupCount(), go.grp2().GroupStartPercent, go.grp2().getGroupCompltdPercent(), go.grp2().getLatestTimeStamp());

        grpDao.update(go.grp3().getGroupName(),go.grp3().getGroupCount(), go.grp3().GroupStartPercent, go.grp3().getGroupCompltdPercent(), go.grp3().getLatestTimeStamp() );



        //Fetching all values from Cache Table
        List<Group> groups = grpDao.findAll();

        for(Group g : groups)
        {
           // Group gobject = g;
            System.out.println("################################");
         /*   System.out.println("#####1 "+gobject.getGroupName());
            System.out.println("#####2 "+gobject.getGroupCount());
            System.out.println("#####3 "+gobject.getGroupStartPercent());
            System.out.println("#####4 "+gobject.getGroupCompltdPercent());
            System.out.println("#####5 "+gobject.getLatestTimeStamp());*/

            System.out.println(g.toString());
            System.out.println("################################");

        }




    }


}