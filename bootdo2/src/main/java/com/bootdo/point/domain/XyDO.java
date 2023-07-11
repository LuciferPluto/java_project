package com.bootdo.point.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 9216 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 09:11:43
 */
public class XyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String pointId;
	//
	private String wgs84Lon;
	//
	private String wgs84Lat;
	//
	private String bdLon;
	//
	private String bdLat;
	//
	private String bdDisName;
	//
	private String bdCityCode;
	//
	private String bdCityName;
	//
	private String bdDisCode;
	//
	private String pointDisId;

	/**
	 * 设置：
	 */
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	/**
	 * 获取：
	 */
	public String getPointId() {
		return pointId;
	}
	/**
	 * 设置：
	 */
	public void setWgs84Lon(String wgs84Lon) {
		this.wgs84Lon = wgs84Lon;
	}
	/**
	 * 获取：
	 */
	public String getWgs84Lon() {
		return wgs84Lon;
	}
	/**
	 * 设置：
	 */
	public void setWgs84Lat(String wgs84Lat) {
		this.wgs84Lat = wgs84Lat;
	}
	/**
	 * 获取：
	 */
	public String getWgs84Lat() {
		return wgs84Lat;
	}
	/**
	 * 设置：
	 */
	public void setBdLon(String bdLon) {
		this.bdLon = bdLon;
	}
	/**
	 * 获取：
	 */
	public String getBdLon() {
		return bdLon;
	}
	/**
	 * 设置：
	 */
	public void setBdLat(String bdLat) {
		this.bdLat = bdLat;
	}
	/**
	 * 获取：
	 */
	public String getBdLat() {
		return bdLat;
	}
	/**
	 * 设置：
	 */
	public void setBdDisName(String bdDisName) {
		this.bdDisName = bdDisName;
	}
	/**
	 * 获取：
	 */
	public String getBdDisName() {
		return bdDisName;
	}
	/**
	 * 设置：
	 */
	public void setBdCityCode(String bdCityCode) {
		this.bdCityCode = bdCityCode;
	}
	/**
	 * 获取：
	 */
	public String getBdCityCode() {
		return bdCityCode;
	}
	/**
	 * 设置：
	 */
	public void setBdCityName(String bdCityName) {
		this.bdCityName = bdCityName;
	}
	/**
	 * 获取：
	 */
	public String getBdCityName() {
		return bdCityName;
	}
	/**
	 * 设置：
	 */
	public void setBdDisCode(String bdDisCode) {
		this.bdDisCode = bdDisCode;
	}
	/**
	 * 获取：
	 */
	public String getBdDisCode() {
		return bdDisCode;
	}
	/**
	 * 设置：
	 */
	public void setPointDisId(String pointDisId) {
		this.pointDisId = pointDisId;
	}
	/**
	 * 获取：
	 */
	public String getPointDisId() {
		return pointDisId;
	}
}
