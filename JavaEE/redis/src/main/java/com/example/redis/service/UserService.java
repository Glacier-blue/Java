package com.example.redis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "user",key = "#id")
    public String getUserName(int id){
        System.out.println("调用getUserName方法"+id);
        return "ID->"+id;
    }
}
