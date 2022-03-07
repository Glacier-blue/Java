package com.example.redis.contoller;


import com.example.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
public class UserContoller {

    @Autowired
    UserService userService;
    @RequestMapping("/get")
    public String getUserName(int id){
        return userService.getUserName(id);
    }
}
