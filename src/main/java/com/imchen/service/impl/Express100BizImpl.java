package com.imchen.service.impl;

import com.imchen.domain.HttpResponse;
import com.imchen.properties.Express100Properties;
import com.imchen.service.Express100Biz;
import com.imchen.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imchen on 2017/6/7.
 */
@Service
public class Express100BizImpl implements Express100Biz {

    @Autowired
    private Express100Properties prop;

    @Override
    public HttpResponse query(String type, String postId) {
        HttpResponse httpResponser;
        try {
            Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put(prop.getParams1(), type);
            paramsMap.put(prop.getParams2(), postId);
            httpResponser = HttpUtil.send(prop.getUrl(), prop.getRequestType(), paramsMap, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return httpResponser;
    }
}
