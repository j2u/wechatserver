package com.imchen.service.impl;

import com.imchen.domain.HttpResponse;
import com.imchen.properties.BingdictProperties;
import com.imchen.service.BingdictBiz;
import com.imchen.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imchen on 2017/6/8.
 */
@Service
public class BingdictBizImpl implements BingdictBiz{


    @Autowired
    private BingdictProperties prop;

    @Override
    public HttpResponse query(String word) {
        HttpResponse httpResponser=null;
        try {
            Map<String,String> paramsMap=new HashMap<>();
            paramsMap.put(prop.getParams1(),word);
            paramsMap.put(prop.getParams2(),prop.getJsonFormat());
            httpResponser= HttpUtil.send(prop.getUrl(),prop.getRequestType(),paramsMap,null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return httpResponser;
    }
}
