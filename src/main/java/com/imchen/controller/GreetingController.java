package com.imchen.controller;

import com.imchen.domain.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by imchen on 2017/6/7.
 */
@RestController
public class GreetingController {

    private static final String template="Hello,%s!";
    private final AtomicLong counter=new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "imchen") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
