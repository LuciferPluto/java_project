package cn.edu.hrbeu.controller;


import cn.edu.hrbeu.Main;
import cn.edu.hrbeu.dao.APIDAO;
import cn.edu.hrbeu.dao.PointDAO;
import cn.edu.hrbeu.service.APILogService;
import cn.edu.hrbeu.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/point")


public class PointController {

    @Autowired
    PointService pointService;

    @Autowired
    PointDAO pointDAO;
    @Autowired
    APIDAO apidao;
    @Autowired
    APILogService apiLogService;
    @RequestMapping("/queryCityNum")
    @ResponseBody
    public  Map<String,Object> queryCityNum(@RequestBody Map paraMap){
        //1.
        List<Map<String,Object>>userList = pointDAO.getUserByName(paraMap);
        Map<String,Object> returnMap = new HashMap();
        if (userList.size()<=0){
           returnMap.put("code","F01") ;
           returnMap.put("msg","用户不存在") ;
           apiLogService.insertAPILog(paraMap.get("username").toString(),paraMap.get("password").toString(),"queryCityNum",returnMap);
            return returnMap;
        }


        //2.
        List<Map<String,Object>> numList = pointDAO.queryNumCity((Map)paraMap.get("data"));
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


    // /point/getPoint
    @RequestMapping("/getPoint")
    @ResponseBody
    public String getPoint(){
        return "hello point";
    }
    @RequestMapping("/queryAllDis")
    @ResponseBody
    public List<Map<String, Object>> queryAllDis(){

        return pointService.queryDisList();

    }


    @RequestMapping("/addPointPerson")
    @ResponseBody
    public Map<String,Object> addPointPerson(@RequestBody Map<String,Object>paraMap){

        Map <String,Object> returnMap = pointService.addPointPerson(paraMap);

        return returnMap;

    }

    @RequestMapping("/queryDisNumber")
    @ResponseBody
    public Map<String,Object> queryDisNumber(@RequestBody Map<String,Object>paraMap){
        Map<String,Object> returnMap = pointService.queryDisNumber(paraMap);
        return returnMap;

    }
    @RequestMapping("/queryDisDayNum")
    @ResponseBody
    public Map<String,Object> queryDisDayNum(@RequestBody Map paraMap){
        Map<String ,Object> returnMap = new HashMap<>();
         returnMap = pointService.queryDisDayNum(paraMap);
         return returnMap;



    }
}
