package com.imchen.controller;

import com.imchen.service.BingdictBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imchen on 2017/6/8.
 */
@RestController
public class BingdictController {

    @Autowired
    private BingdictBiz bingdictBiz;

    @RequestMapping("/bingdict/{word}")
    public String query(@PathVariable String word){
       return bingdictBiz.query(word).getContent();
    }

}
