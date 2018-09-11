package com.zl.weathercloud.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.zl.weathercloud.util.XmlBuilder;
import com.zl.weathercloud.vo.City;
import com.zl.weathercloud.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * 获取城市列表实现类，将xml字符串转出java对象
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");//读取xml文件
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));//有中文
        StringBuffer buffer = new StringBuffer();//读取到这个buffer中去
        String line = "";
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        // XML转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }

}
