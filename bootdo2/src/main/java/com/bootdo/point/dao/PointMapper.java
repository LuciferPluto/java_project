package com.bootdo.point.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PointMapper {

@Select(" SELECT " +
        " t2.dis_name," +
        " sum( t.person_number ) person_num " +
        "FROM" +
        " point_person_count t," +
        " point_xy t1," +
        " dis_info t2 " +
        "WHERE" +
        " t.point_id = t1.point_id " +
        " AND t2.dis_id = t1.point_dis_id " +
        " AND t2.city_code4 = #{city_code4} " +
        " AND t.count_time LIKE '${count_date}%' " +
        "GROUP BY" +
        " t2.dis_name ")
    public List<Map<String, Object>> queryNumByDate(Map paraMap) ;

@Select(" select * from point_xy ")
    List<Map<String, Object>> queryAllPoint();
@Select(" SELECT substr(t.update_time, 1 , 8 ) update_date , COUNT(1)  num FROM api_log t GROUP BY substr(t.update_time, 1 , 8);")
    List<Map<String, Object>> queryNumAPIDate();

@Select(" SELECT " +
        " t1.city_name , sum(t.person_number) num " +
        "FROM " +
        " point_person_count t, " +
        " dis_info t1, " +
        " point_xy t2  " +
        "WHERE " +
        " t.point_id = t2.point_id  " +
        " AND t1.dis_id = t2.point_dis_id " +
        " group by t1.city_name "  )
    List<Map<String, Object>> queryCityPercent();
    @Select("   SELECT " +
            " t1.dis_name `name` , sum(t.person_number) `value` " +
            "FROM " +
            " point_person_count t, " +
            " dis_info t1, " +
            " point_xy t2  " +
            "WHERE " +
            " t.point_id = t2.point_id  " +
            " AND t1.dis_id = t2.point_dis_id " +
            " and city_code4 = #{city_code4} " +
            " group by t1.dis_name ")
    List<Map<String, Object>> queryDisPercent(Map<String, Object> paramMap);
}
