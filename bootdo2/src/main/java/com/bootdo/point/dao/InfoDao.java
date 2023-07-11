package com.bootdo.point.dao;

import com.bootdo.point.domain.InfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-10 13:35:56
 */
@Mapper
public interface InfoDao {

	InfoDO get(String disId);
	
	List<InfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(InfoDO info);
	
	int update(InfoDO info);
	
	int remove(String dis_id);
	
	int batchRemove(String[] disIds);
}
