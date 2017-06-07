package com.imchen.service;

import com.imchen.domain.HttpResponse;

/**
 * Created by imchen on 2017/6/7.
 */
public interface Express100Biz {

    HttpResponse query(String type,String postId);
}
