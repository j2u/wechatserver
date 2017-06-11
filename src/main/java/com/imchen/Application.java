package com.imchen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by imchen on 2017/6/7.
 */
@SpringBootApplication
@MapperScan("com.imchen.mapper")
public class Application {
    public static  void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
