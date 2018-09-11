package com.zl.weathercloud.controller;

import com.zl.weathercloud.service.CityDataService;
import com.zl.weathercloud.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * 从页面获取天气数据
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

    /**
     * g根据id获取天气
     * @param cityId
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        model.addAttribute("title", "lgzkd的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

    /**
     * 根据名称获取天气
     * @param cityName
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/cityName/{cityName}")
    public ModelAndView getReportByCityName(@PathVariable("cityName") String cityName,Model model) throws Exception {
        model.addAttribute("title", "lgzkd的天气预报");
        model.addAttribute("cityName", cityName);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityName(cityName));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
