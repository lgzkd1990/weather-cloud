package com.zl.weathercloud.vo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityTest {

    @Test
    public void testCity(){
        City city = new City();
        city.setCityName("12321");
        System.out.println(city.toString());
    }
}
