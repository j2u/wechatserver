package com.imchen.service;

import com.imchen.domain.HttpResponse;
import org.springframework.stereotype.Service;

/**
 * Created by imchen on 2017/6/8.
 */
@Service
public interface BingdictBiz {

    public HttpResponse query(String word);
}