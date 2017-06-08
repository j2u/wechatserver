package com.imchen.controller;

import com.imchen.service.Express100Biz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imchen on 2017/6/8.
 */
@RestController
@RequestMapping("/express100")
public class Express100Controller {

    @Autowired
    Express100Biz express100Biz;

    @RequestMapping("/query/{type}/{postid}")
    public String query(@PathVariable String type,@PathVariable String postid){
        return express100Biz.query(type,postid).getContent();
    }
}
