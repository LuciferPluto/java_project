package com.bootdo.point.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 9216 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-10 13:35:56
 */
public class InfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String disId;
	//
	private String disCode;
	//
	private String disName;
	//
	private String cityCode3;
	//
	private String cityCode4;
	//
	private String cityName;

	/**
	 * 设置：
	 */
	public void setDisId(String disId) {
		this.disId = disId;
	}
	/**
	 * 获取：
	 */
	public String getDisId() {
		return disId;
	}
	/**
	 * 设置：
	 */
	public void setDisCode(String disCode) {
		this.disCode = disCode;
	}
	/**
	 * 获取：
	 */
	public String getDisCode() {
		return disCode;
	}
	/**
	 * 设置：
	 */
	public void setDisName(String disName) {
		this.disName = disName;
	}
	/**
	 * 获取：
	 */
	public String getDisName() {
		return disName;
	}
	/**
	 * 设置：
	 */
	public void setCityCode3(String cityCode3) {
		this.cityCode3 = cityCode3;
	}
	/**
	 * 获取：
	 */
	public String getCityCode3() {
		return cityCode3;
	}
	/**
	 * 设置：
	 */
	public void setCityCode4(String cityCode4) {
		this.cityCode4 = cityCode4;
	}
	/**
	 * 获取：
	 */
	public String getCityCode4() {
		return cityCode4;
	}
	/**
	 * 设置：
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * 获取：
	 */
	public String getCityName() {
		return cityName;
	}
}
