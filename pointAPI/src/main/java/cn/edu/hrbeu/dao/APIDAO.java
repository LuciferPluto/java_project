package cn.edu.hrbeu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface APIDAO {


    @Insert("insert into api_log values ( #{LogId}, #{username},#{password},#{apiCode},#{code},#{msg},#{updateTime} )")

    public int insertAPILog(Map map);
}
