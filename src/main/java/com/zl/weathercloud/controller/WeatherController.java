package com.zl.weathercloud.controller;

import com.zl.weathercloud.service.WeatherDataService;
import com.zl.weathercloud.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherDataService weatherDataService;
	
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
		return weatherDataService.getDataByCityId(cityId);
	}

	//这个需要编码吗？为什么不能直接中文呢，用postman不可以的，浏览器会自动编码
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}


	@GetMapping("/cityName")
	public WeatherResponse getWeatherByCityName2(@RequestParam("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}
}
