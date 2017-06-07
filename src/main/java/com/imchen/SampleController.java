package com.imchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by imchen on 2017/6/7.
 */
@EnableAutoConfiguration
public class SampleController {
    public  static  void main(String args[]){
        SpringApplication.run(SampleController.class,args);
    }
}
