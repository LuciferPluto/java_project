package com.proj.service;

import com.alibaba.fastjson.JSON;
import com.proj.dao.DisDAO;
import com.proj.entitles.DisEntity;
import com.proj.entitles.Point;
import com.proj.utils.DisUtils;
import com.proj.utils.PointUtils;
import com.proj.dao.PointDAO;
import com.proj.utils.WebUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class PointService {

    PointUtils pointUtils = new PointUtils();
    PointDAO pointDAO = new PointDAO();
    DisUtils disUtils = new DisUtils();
    DisDAO disDAO = new DisDAO();
    String bdAK = "NFYFvQrl8zDkPgB8iH6qQMCRTiasWysn";
    String bdXYUrl = "https://api.map.baidu.com/geoconv/v1/?";
    String bdAreaUrl = "https://api.map.baidu.com/reverse_geocoding/v3/?";


    static String pointPath = "C:\\workjob2023\\code\\mycode\\input\\point20210303.csv";
    static String disPath = "C:\\workjob2023\\code\\mycode\\input\\dim_dis_code.txt";

    WebUtils webUtils = new WebUtils();
    public static void main(String[] args) {
        PointService service = new PointService();
        service.addPoint(pointPath);
        service.addDis(disPath);
        service.updatePointBDArea();
        service.updatePointArea();
        service.updatePointBdXY();

    }
    public  void addDis(String disPath){
        disDAO.truncateDis();
        List<DisEntity> disEntityList = disUtils.getDisInfo(disPath);

        for(int i = 0; i < disEntityList.size();i++){
            disDAO.insertDis(disEntityList.get(i));
        }
    }
    public  void addPoint(String pointPath){
        List<Point> pointList = pointUtils.getPointList(pointPath);
        System.out.println("pointList.size() = " + pointList.size());
        for(int i = 0;i<pointList.size();i++){
            Point point = pointList.get(i);
            List<Point> xyPointList = pointDAO.queryPointByXY(point);
            if(xyPointList.size()<1){
                pointDAO.insertPoint(point);
            }
        }

        System.out.println("PointService.addPoint end");
    }

    public void  updatePointArea(){
        List<Point> pointList =  pointDAO.queryAllPoint();
        try{
            for(int i = 0;i<pointList.size();i++){
               Point point = pointList.get(i) ;
               String disCode = point.getBd_dis_code();
               List<DisEntity>disEntityList = disDAO.queryDisListByCode(disCode);
               if(disEntityList.size()>0){
                   point.setPoint_dis_id(disEntityList.get(0).getDisId());
                   pointDAO.updatePointArea(point);
                }


            }

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public  void  updatePointBDArea(){
        List<Point> pointList =  pointDAO.queryAllPoint();
        try{
            for(int i = 0;i<pointList.size();i++){
                Point point = pointList.get(i);
                Map params = new LinkedHashMap<String, String>();
                params.put("ak", bdAK);
                params.put("output", "json");
                params.put("coordtype", "wgs84ll");
                params.put("extensions_poi", "0");
                params.put("location", point.getWgs84lat()+","+point.getWgs84Lon());

                String str = webUtils.requestGetAK(bdAreaUrl,params);
                System.out.println("str = " + str);
                Map resultMap = (Map)JSON.parseObject(str,Map.class).get("result");
                System.out.println("resultMap = " + resultMap);
                String bdCityCode = resultMap.get("cityCode")+"";
                Map addMap = (Map) resultMap.get("addressComponent");
                String cityName = addMap.get("city")+"";
                String disCode = addMap.get("adcode")+"";
                String disName = addMap.get("district")+"";
                point.setBd_city_code(bdCityCode);
                point.setBd_city_name(cityName);
                point.setBd_dis_code(disCode);
                point.setBd_dis_name(disName);

                pointDAO.updatePointBDArea(point);

            }

        }catch (Exception exception){
            exception.printStackTrace();
        }



    }

    public void updatePointBdXY(){
         // List<Point> pointList = pointUtils.getPointList(PointPath);

            List<Point> pointList =  pointDAO.queryAllPoint();
        try{
            for(int i = 0;i<pointList.size();i++){
                Map params = new LinkedHashMap<String, String>();
                params.put("coords", pointList.get(i).getWgs84Lon() + "," + pointList.get(i).getWgs84lat());
                params.put("from", "1");
                params.put("to", "5");
                params.put("ak", bdAK);

                String str = webUtils.requestGetAK(bdXYUrl,params);
                System.out.println("str = " + str);

                Map resultMap = JSON.parseObject(str,Map.class);
                System.out.println("resultMap.toString() = "+ resultMap.toString());
                List <Map<String,Object>> xyList = ( List <Map<String,Object>>)resultMap.get("result");
                Map xyMap = xyList.get(0);
                String lon = xyMap.get("x")+"";
                String lat = xyMap.get("y")+"";
                System.out.println("lat = " + lat);
                System.out.println("lon = " + lon);

                Point point = pointList.get(i);
                point.setBdLat(lat);
                point.setBdLon(lon);
                pointDAO.updatePointXY(point);




            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
