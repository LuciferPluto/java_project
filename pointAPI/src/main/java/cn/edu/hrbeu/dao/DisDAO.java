package cn.edu.hrbeu.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DisDAO {

    public List<Map<String,Object>> queryAllDis();

}
