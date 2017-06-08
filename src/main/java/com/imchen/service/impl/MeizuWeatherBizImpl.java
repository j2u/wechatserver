package com.imchen.service.impl;

import com.imchen.domain.HttpResponse;
import com.imchen.service.MeizuWeatherBiz;
import com.imchen.utils.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imchen on 2017/6/7.
 */
@Service
public class MeizuWeatherBizImpl implements MeizuWeatherBiz {

    private static final String MEIZUAPI="http://aider.meizu.com/app/weather/listWeather";

    @Override
    public HttpResponse queryByCityId(String cityId) {
        Map<String,String> map=new HashMap<>();
        map.put("cityIds",cityId);
        HttpResponse responser;
        try {
            responser=HttpUtil.send(MEIZUAPI,"get",map,null);
        } catch (Exception e) {
            return null;
        }
        return responser;
    }
}
