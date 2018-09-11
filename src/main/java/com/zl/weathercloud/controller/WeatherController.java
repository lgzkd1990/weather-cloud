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
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}


	@GetMapping("/cityName")
	public WeatherResponse getWeatherByCityName2(@RequestParam("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}
}
