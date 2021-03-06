package com.zl.weathercloud.service;


import com.zl.weathercloud.vo.Weather;

public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);

	Weather getDataByCityName(String cityName);
}
