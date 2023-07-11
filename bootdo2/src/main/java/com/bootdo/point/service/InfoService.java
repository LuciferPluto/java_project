package com.bootdo.point.service;

import com.bootdo.point.domain.InfoDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 9216 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-10 13:35:56
 */
public interface InfoService {
	
	InfoDO get(String disId);
	
	List<InfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InfoDO info);
	
	int update(InfoDO info);
	
	int remove(String disId);
	
	int batchRemove(String[] disIds);
}
