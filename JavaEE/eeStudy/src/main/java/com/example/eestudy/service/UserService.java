package com.example.eestudy.service;


import com.example.eestudy.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private int count=0;
    @Cacheable(cacheNames = "user",key = "#id")
    public User getUserName(int id){
        User user=new User();
        user.setUsername(String.valueOf(id));
        user.setId(id);
        String msg="调用getUserName方法:"+count+" ";
        count++;
        System.out.println(msg);
        return user;
    }
    private int count2=0;
    @CachePut(cacheNames = "user",key = "#id")
    public User updateUserName(int id){
        User user=new User();
        user.setUsername(String.valueOf(id+1));
        user.setId(id);
        String msg="调用updateUserName方法:"+count2+" ";
        System.out.println(msg);
        count2++;
        return user;
    }
    private int count3=0;
    @CacheEvict(cacheNames = "user",key = "#id")
    public User deleteUserName(int id){
        User user=new User();
        user.setId(id);
        user.setUsername(String.valueOf(id-1));
        String msg="调用deleteUserName方法:"+count3+" ";
        System.out.println(msg);
        count3++;
        return user;
    }
}
