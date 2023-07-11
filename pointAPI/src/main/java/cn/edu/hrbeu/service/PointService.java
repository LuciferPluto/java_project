package cn.edu.hrbeu.service;

import cn.edu.hrbeu.dao.DisDAO;
import cn.edu.hrbeu.dao.PointDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service

public class PointService {


    @Autowired
    DisDAO disDAO;
    @Autowired
    PointDAO pointDAO;
    @Autowired
    APILogService apiLogService;
    public List<Map<String,Object>> queryDisList(){
        return disDAO.queryAllDis();

    }

    public Map<String, Object> addPointPerson(Map<String, Object> paraMap) {

        List<Map<String,Object>> pointList = pointDAO.queryAllPoint();
        String dealTime = paraMap.get("countTime") + "";

        for (int i = 0;i<pointList.size();i++){

            Map<String,Object> pointMap = new HashMap<>();
            pointMap.put("personNum",(int)(Math.random()*10000));
            pointMap.put("countTime",dealTime);
            pointMap.put("countId", UUID.randomUUID().toString());
            pointMap.put("pointId",pointList.get(i).get("pointId"));
            pointDAO.insertPersonNum(pointMap);

        }
        Map <String,Object> map = new HashMap();
        map.put("code","0");
        map.put("msg","插入成功");
        return map;
    }

    public Map<String,Object>queryDisNumber(Map<String,Object> paraMap){

        //用户验证
        Map<String,Object> returnMap = new HashMap<>();
        List<Map<String,Object>> userList = pointDAO.getUserByName(paraMap);
        if (userList.size() > 0) {
            // 如果验证成功则
            //查询某地市下所有区县的人数
            Map<String, Object> dataMap = (Map<String, Object>) paraMap.get("data");
            if (null == dataMap) {
                returnMap.put("code", "F02");
                returnMap.put("msg", "参数错误！");
                apiLogService.insertAPILog(paraMap.get("username") + "", paraMap.get("password") + "", "queryDisNumber", returnMap);
                return returnMap;
            }
            List<Map<String, Object>> disNumberList = pointDAO.getDisNumberByCity(dataMap);
            if (disNumberList.size() <= 0) {
                returnMap.put("code", "S00");
                returnMap.put("msg", "查询无数据");
                apiLogService.insertAPILog(paraMap.get("username") + "", paraMap.get("password") + "", "queryDisNumber", returnMap);
                return returnMap;
            }
            returnMap.put("code", "S00");
            returnMap.put("msg", "查询成功");
            apiLogService.insertAPILog(paraMap.get("username") + "", paraMap.get("password") + "", "queryDisNumber", returnMap);

            returnMap.put("data", disNumberList);
            return returnMap;
        } else {
            // 如果验证不成功则返回错误代码错误信息
            returnMap.put("code", "F01");
            returnMap.put("msg", "用户信息错误");
            apiLogService.insertAPILog(paraMap.get("username") + "", paraMap.get("password") + "", "queryDisNumber", returnMap);
            return returnMap;
        }
    }

    public Map<String, Object> queryDisDayNum(Map paraMap) {
        List<Map<String,Object>>userList = pointDAO.getUserByName(paraMap);
        Map<String,Object> returnMap = new HashMap();
        if (userList.size()<=0){
            returnMap.put("code","F01") ;
            returnMap.put("msg","用户不存在") ;
            apiLogService.insertAPILog(paraMap.get("username").toString(),paraMap.get("password").toString(),"queryCityNum",returnMap);
            return returnMap;
        }

        //2.
        List<Map<String,Object>> numList = pointDAO.queryDisDayNum((Map)paraMap.get("data"));
        if (userList.size()<=0){
            returnMap.put("code","S01") ;
            returnMap.put("msg","查询无数据") ;
            apiLogService.insertAPILog(paraMap.get("username").toString(),paraMap.get("password").toString(),"queryCityNum",returnMap);
            return returnMap;
        }

        //3.
        returnMap.put("code","S00") ;
        returnMap.put("msg","查询成功") ;
        returnMap.put("data",numList);
        apiLogService.insertAPILog(paraMap.get("username").toString(),paraMap.get("password").toString(),"queryCityNum",returnMap);
        return returnMap;




    }
}


