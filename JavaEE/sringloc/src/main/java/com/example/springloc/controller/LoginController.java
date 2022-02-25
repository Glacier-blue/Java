package com.example.springloc.controller;



import com.example.springloc.entity.User;
import com.example.springloc.service.LoginService;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Controller;


@Controller

public class LoginController {
    //注入方式1：属性注解
//    @Autowired
    private LoginService loginService;

    //注入方式2：setter注入
//    @Autowired
//    public void setLoginService(LoginService loginService) {
//        this.loginService = loginService;
//    }

    //注入方式3：构造器注入
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public void say(){
        loginService.sayHello();
    }


    @Bean
    public User user1(){
        User user=new User();
        user.setName("wfm");
        user.setPassword("123");
        return user;
    }
    @Bean
    public User user2(){
        User user=new User();
        user.setName("wangfuming");
        user.setPassword("111");
        return user;
    }
}
