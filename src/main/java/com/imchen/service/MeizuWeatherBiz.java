package com.imchen.service;

import com.imchen.domain.HttpResponse;

/**
 * Created by imchen on 2017/6/7.
 */
public interface MeizuWeatherBiz {

    public HttpResponse queryByCityId(String cityId);
}
