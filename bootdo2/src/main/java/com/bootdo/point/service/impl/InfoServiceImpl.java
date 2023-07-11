package com.bootdo.point.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.point.dao.InfoDao;
import com.bootdo.point.domain.InfoDO;
import com.bootdo.point.service.InfoService;



@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	private InfoDao infoDao;
	
	@Override
	public InfoDO get(String disId){
		return infoDao.get(disId);
	}
	
	@Override
	public List<InfoDO> list(Map<String, Object> map){
		return infoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return infoDao.count(map);
	}
	
	@Override
	public int save(InfoDO info){
		return infoDao.save(info);
	}
	
	@Override
	public int update(InfoDO info){
		return infoDao.update(info);
	}
	
	@Override
	public int remove(String disId){
		return infoDao.remove(disId);
	}
	
	@Override
	public int batchRemove(String[] disIds){
		return infoDao.batchRemove(disIds);
	}
	
}
