package com.proj.dao;

import com.proj.entitles.Point;
import com.proj.utils.DBUtils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class PointDAO {

    DBUtils dbUtils = new DBUtils();
    public int insertPoint(Point point){
        String sql = "INSERT INTO pointdb1.point_xy (point_id, wgs84_lon, wgs84_lat, bd_lon, bd_lat, bd_dis_name, bd_city_code," +
                " bd_city_name, bd_dis_code, " + "point_dis_id)" +
                "VALUES ('" + UUID.randomUUID().toString() + "', '" + point.getWgs84Lon() + "','" + point.getWgs84lat() + "', '', '', '', '', '', '', '');";
        System.out.println("sql = " + sql);
        dbUtils.close();
        return dbUtils.doSave(sql);

    }

    public  int updatePointXY(Point point){
        String sql = " UPDATE point_xy  " +
                "SET bd_lon = '" + point.getBdLon() + "', " +
                "bd_lat = '" + point.getBdLat() + "'  " +
                "WHERE " +
                " point_id = '" + point.getPointId() + "'  ";
        dbUtils.close();
        return dbUtils.doSave(sql);



    }
    public List<Point> queryAllPoint(){
        try{
            String sql = "select * from point_xy" ;
            ResultSet rs = dbUtils.doQuery(sql);
            List<Point>pointList = new ArrayList<>();
            while (rs.next()){
                Point point = new Point();
                point.setPointId(rs.getString(1));
                point.setWgs84Lon(rs.getString(2));
                point.setWgs84lat(rs.getString(3));
                point.setBdLon(rs.getString(4));
                point.setBdLat(rs.getString(5));
                point.setBd_dis_name(rs.getString(6));
                point.setBd_city_code(rs.getString(7));
                point.setBd_city_name(rs.getString(8));
                point.setBd_dis_code(rs.getString(9));
                point.setPoint_dis_id(rs.getString(10));
                pointList.add(point);

            }
            return pointList;
        }catch (Exception e){
            e.printStackTrace();

        }
        return  null;
    }

    public void updatePointBDArea(Point point) {
        String sql = "UPDATE point_xy " +
                "SET bd_dis_name ='" +point.getBd_dis_name()+"',"+
                "bd_city_code = '"+point.getBd_city_code()+"', " +
                "bd_city_name = '"+point.getBd_city_name()+"', " +
                "bd_dis_code = '"+point.getBd_dis_code()+"' " +
                " WHERE point_id = '"+point.getPointId()+"' ";

        dbUtils.doSave(sql);
    }


    public List<Point> queryPointByXY(Point point) {

        String sql = " select point_id from point_xy t  " +
                "where t.wgs84_lon = '" + point.getWgs84Lon() + "' and t.wgs84_lat = '" + point.getWgs84lat() + "'  ";



        ResultSet rs = dbUtils.doQuery(sql);
        List<Point> pointList = new ArrayList<>();
        try {
            while (rs.next()) {
                Point xyPoint = new Point();
                xyPoint.setPointId(rs.getString(1));
                pointList.add(xyPoint);
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return pointList;

    }

    public void updatePointArea(Point point) {
        String sql = " UPDATE point_xy " +
                "SET point_dis_id  = '" + point.getPoint_dis_id() + "' " +
                "where point_id = '" + point.getPointId() + "'  ";
        System.out.println("sql = " + sql);
        dbUtils.doSave(sql);


    }
}
