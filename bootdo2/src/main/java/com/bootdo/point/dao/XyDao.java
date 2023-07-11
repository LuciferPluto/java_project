package com.bootdo.point.dao;

import com.bootdo.point.domain.XyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 09:11:43
 */
@Mapper
public interface XyDao {

	XyDO get(String pointId);
	
	List<XyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(XyDO xy);
	
	int update(XyDO xy);
	
	int remove(String point_id);
	
	int batchRemove(String[] pointIds);
}
