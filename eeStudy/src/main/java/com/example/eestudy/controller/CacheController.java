package com.example.eestudy.controller;


import com.example.eestudy.model.User;
import com.example.eestudy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//调用缓存
@RequestMapping("/cache")
@Controller
@ResponseBody
public class CacheController {

    private final UserService userService;

    public CacheController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("addCache")
    public User method6(int id){
        return userService.getUserName(id);
    }
    @RequestMapping("updateCache")
    public User method7(int id){
        return userService.updateUserName(id);
    }
    @RequestMapping("deleteCache")
    public User method8(int id){
        return userService.deleteUserName(id);
    }
}
