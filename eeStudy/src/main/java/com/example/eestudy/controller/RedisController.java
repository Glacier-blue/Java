package com.example.eestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    public void method(){
        redisTemplate.opsForValue().set("wangfuming","hellow");
    }
    @RequestMapping("/method1")
    public Object method1(String name){
        method();
        return redisTemplate.opsForValue().get(name);
    }
}
