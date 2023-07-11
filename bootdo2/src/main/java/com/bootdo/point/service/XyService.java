package com.bootdo.point.service;

import com.bootdo.point.domain.XyDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 9216 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 09:11:43
 */
public interface XyService {
	
	XyDO get(String pointId);
	
	List<XyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(XyDO xy);
	
	int update(XyDO xy);
	
	int remove(String pointId);
	
	int batchRemove(String[] pointIds);
}
