package com.bootdo.point.service.impl;

import com.alibaba.fastjson.JSON;
import com.bootdo.point.utils.PointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.point.dao.XyDao;
import com.bootdo.point.domain.XyDO;
import com.bootdo.point.service.XyService;



@Service
public class XyServiceImpl implements XyService {
	String bdAK = "fn4tOMEkVemfRQpuGPh4BgsCFnRaYx0E";
	String bdAreaUrl = "https://api.map.baidu.com/reverse_geocoding/v3/?";
	@Autowired
	private XyDao xyDao;
	
	@Override
	public XyDO get(String pointId){
		return xyDao.get(pointId);
	}
	
	@Override
	public List<XyDO> list(Map<String, Object> map){
		return xyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return xyDao.count(map);
	}
	
	@Override
	public int save(XyDO xy){

		String bdLon = xy.getBdLon();
		String bdLat = xy.getBdLat();
		PointUtils pointUtils = new PointUtils();
		double lon_db1 = Double.parseDouble(bdLon);
		double lat_db1 = Double.parseDouble(bdLat);

		double [] wgs_db1 = pointUtils.bd09towgs84(lon_db1,lat_db1);
		double wgs84lon = wgs_db1[0];
		double wgs84lat = wgs_db1[1];

		xy.setWgs84Lat(wgs84lat+"");
		xy.setWgs84Lon(wgs84lon+"");

		Map params = new LinkedHashMap<String, String>();
		params.put("ak", bdAK);
		params.put("output", "json");
		params.put("coordtype", "wgs84ll");
		params.put("extensions_poi", "0");
		params.put("location", xy.getWgs84Lat() + "," + xy.getWgs84Lon());
		try {
			String str = pointUtils.requestGetAK(bdAreaUrl, params);
			Map resultMap = (Map) JSON.parseObject(str, Map.class).get("result");
			String bdCityCode = resultMap.get("cityCode") + "";
			Map addrMap = (Map) resultMap.get("addressComponent");
			String cityName = addrMap.get("city") + "";
			String disCode = addrMap.get("adcode") + "";
			String disName = addrMap.get("district") + "";
			xy.setBdCityCode(bdCityCode);
			xy.setBdCityName(cityName);
			xy.setBdDisCode(disCode);
			xy.setBdDisName(disName);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return xyDao.save(xy);
	}
	
	@Override
	public int update(XyDO xy){
		return xyDao.update(xy);
	}
	
	@Override
	public int remove(String pointId){
		return xyDao.remove(pointId);
	}
	
	@Override
	public int batchRemove(String[] pointIds){
		return xyDao.batchRemove(pointIds);
	}
	
}
