package cn.edu.hrbeu.task;


import cn.edu.hrbeu.dao.PointDAO;
import com.sun.org.apache.bcel.internal.generic.DADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class PointTask {

    @Autowired
    PointDAO pointDAO;
    // @Scheduled(cron = " * * * * * ? ")
    public void testTask(){
        System.out.println(" PointTask.testTask" );
    }
    //@Scheduled(cron = " * * * * * ? ")

    public void insertPointCount(){

        List<Map<String,Object>> pointList = pointDAO.queryAllPoint();

        for (int i = 0;i<pointList.size();i++){

            Map<String,Object> pointMap = new HashMap<>();
            pointMap.put("personNum",(int)(Math.random()*10000));
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String strCountTime = sdf.format(date);
            pointMap.put("countTime",strCountTime);
            pointMap.put("countId", UUID.randomUUID().toString());
            pointMap.put("pointId",pointList.get(i).get("pointId"));
            pointDAO.insertPersonNum(pointMap);

        }


    }


}
