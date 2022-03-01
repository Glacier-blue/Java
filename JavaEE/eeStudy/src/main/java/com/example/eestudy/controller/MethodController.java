package com.example.eestudy.controller;


import com.example.eestudy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/method")
@Controller
@ResponseBody
public class MethodController {
    private final Logger logger= LoggerFactory.getLogger(MethodController.class);

    @RequestMapping("/people/{pid}/pets/{aid}")
    public String method1(@PathVariable("pid") String id1,@PathVariable("aid") String id2) {
        logger.error("用户id:"+id1+",宠物id:"+id2);
        return "用户id:"+id1+",宠物id:"+id2;
    }

    @RequestMapping("/getname")
    public String method2(String name){
        return "姓名:"+name;
    }

    @PostMapping("/login")
    public String method3(@RequestBody String name,String password){
        logger.error("用户名："+name+"，密码："+password);
        return "name:"+name+",password:"+password;
    }
    @RequestMapping("/register")
    public String method4(@RequestParam String name,@RequestParam String password){
        logger.error("用户名："+name+"，密码："+password);
        return "name:"+name+",password:"+password;
    }

    @RequestMapping("/reg")
    public String method(User user){
        System.out.println("信息:"+user);
        return user.toString();
    }
    @RequestMapping("/test")
    public User method5(@RequestBody User user){
        logger.error("用户名："+user.getUsername()+"，密码："+user.getPassword());
        return user;
    }
}
