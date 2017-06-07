package com.imchen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imchen on 2017/6/7.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "hello world!";
    }
}
