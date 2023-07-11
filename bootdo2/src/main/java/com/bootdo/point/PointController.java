package com.bootdo.point;

import com.alibaba.fastjson.JSON;
import com.bootdo.point.dao.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/point")
public class PointController {

    @Autowired
    PointMapper pointMapper;
    @RequestMapping("showPointPage")
    public String showPointPage (){


        return "/point/main.html";
    }

    @RequestMapping("showMap")
    public String showMap(){
        return "/point/showMap.html";
    }
    @RequestMapping("/queryNumByDate")
    @ResponseBody
    public String queryNumByDate(@RequestBody Map paraMap){

        List<Map<String,Object>> numList = pointMapper.queryNumByDate(paraMap);

        return JSON.toJSONString(numList);




    }
    @RequestMapping("/queryAllPoint")
    @ResponseBody
    public String queryAllPoint(){

        List<Map<String,Object>> PointList = pointMapper.queryAllPoint();
        return JSON.toJSONString(PointList);


    }
    @RequestMapping("/queryNumAPIDate")
    @ResponseBody
    public String queryNumAPIDate(){
        List<Map<String,Object>> NumList = pointMapper.queryNumAPIDate();
        return JSON.toJSONString(NumList);

    }
    @RequestMapping("/queryCityPercent")
    @ResponseBody
    public String queryCityPercent(){
        List<Map<String,Object>> numList = pointMapper.queryCityPercent();
        return JSON.toJSON(numList).toString();

    }
    @RequestMapping("/queryDisPercent")
    @ResponseBody
    public String queryDisPercent ( @RequestBody Map<String , Object> paramMap ){
        System.out.println("paramMap.toString() = " + paramMap.toString());
        List<Map<String,Object>> numList = pointMapper.queryDisPercent(paramMap);
        return JSON.toJSON(numList).toString();
    }
}


