package cn.edu.hrbeu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PointDAO {


    List<Map<String, Object>> queryAllPoint();


    void insertPersonNum(Map<String, Object> pointMap);

    List<Map<String, Object>> getUserByName(Map<String, Object> paraMap);


    List<Map<String, Object>> getDisNumberByCity(Map<String, Object> dataMap);

    @Select("SELECT  " +
            " t2.city_name,  " +
            " t2.city_code4,  " +
            " SUM( person_number ) person_number   " +
            "FROM  " +
            " point_person_count t,  " +
            " point_xy t1,  " +
            " dis_info t2   " +
            "WHERE  " +
            " t.point_id = t1.point_id   " +
            " AND t.point_id = t1.point_id   " +
            " AND t2.city_code4 = #{city_code4} " +
            "" +
            " " +
            "   " +
            "GROUP BY  " +
            " t2.city_name,  " +
            " t2.city_code4")
    List<Map<String, Object>> queryNumCity(Map<String,Object> dataMap);



    List<Map<String, Object>> queryDisDayNum(Map data);
}
