package com.proj.utils;
import com.proj.entitles.Point;
import java.util.ArrayList;
import java.util.List;

public class PointUtils {
    public static void main(String[] args) {
        PointUtils pointUtils = new PointUtils();
        String filepath = "C:\\workjob2023\\code\\mycode\\input\\point20210303.csv";
        List<Point> pointList = pointUtils.getPointList(filepath);

        for (int i = 0; i < pointList.size(); i++){
            System.out.println("wgs84Lon = "+ pointList.get(i).getWgs84Lon()
                    +",wgs84Lat = "+ pointList.get(i).getWgs84lat());

        }

    }
    public List<Point> getPointList(String filePath)  {
        FileUtils fileUtils = new FileUtils();
        List<String>pointStr = fileUtils.file2list(filePath);
        List<Point>pointList = new ArrayList<>();
        for (int i = 0; i < pointStr.size(); i++){
            String str = pointStr.get(i);
            String[]strs = str.split(",");
            Point point = new Point();
            point.setWgs84Lon(strs[0]);
            point.setWgs84lat(strs[1]);
            pointList.add(point);
        }

        return pointList;

    }








}
