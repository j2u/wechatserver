package com.imchen.controller;

import com.imchen.domain.HttpResponse;
import com.imchen.service.MeizuWeatherBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imchen on 2017/6/7.
 */
@RestController
@RequestMapping("/weather")
public class MeizuWeatherController {

    @Autowired
    MeizuWeatherBiz meizuWeatherBiz;

    @RequestMapping("/meizu")
    @ResponseBody
    public String queryByCityId(@RequestParam(value = "id",defaultValue = "101240101") String id){
        HttpResponse httpResponser=meizuWeatherBiz.queryByCityId(id);
        return httpResponser.getContent();
    }
}
