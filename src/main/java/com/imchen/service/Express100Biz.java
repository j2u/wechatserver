package com.imchen.service;

import com.imchen.domain.HttpResponse;
import org.springframework.stereotype.Service;

/**
 * Created by imchen on 2017/6/7.
 */
@Service
public interface Express100Biz {

    HttpResponse query(String type,String postId);
}
