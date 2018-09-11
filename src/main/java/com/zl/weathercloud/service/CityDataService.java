package com.zl.weathercloud.service;

import com.zl.weathercloud.vo.City;

import java.util.List;



/**
 * City Data Service.
 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
