package com.example.springstudyboot.controller;

import com.example.springstudyboot.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/mvc")
public class MVCController {
    private static final Logger logger = LoggerFactory.getLogger(MVCController.class);

    @RequestMapping("/index1")
    public String getIndex1(){
        logger.error("这是跳转链接");
        System.out.println("这是跳转连接");
        return "redirect:/index.html";
    }

    @RequestMapping("/index2")
    public String getIndex2(){
        logger.error("这是请求转发");
        System.out.println("请求转发");
        return "forward:/index.html";
    }

    @RequestMapping("/index3")
    public String getIndex3(HttpServletResponse resp) {
        logger.error("这是永久跳转");
        System.out.println("这是永久跳转");
        resp.setStatus(301);
        resp.setHeader("Location", "/index.html");
        return null;
    }

    @GetMapping("/index4")
    public String getIndex4(){
        logger.error("我是 index4");
        return "/index.html";
    }

    @PostMapping("/index5")
    public String getIndex5(){
        logger.error("我是 index5");
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/index6")
    public String getIndex6(){
        System.out.println("index6");
        return "index/html";
    }

    private final ObjectMapper mapper =new ObjectMapper();
    @RequestMapping("/index7")
    @ResponseBody
    public String getIndex7() throws JsonProcessingException {
        System.out.println("index7");
        User user=new User();
        user.setUsername("Java");
        user.setPassword("最好的语言");
        logger.error("index4函数");
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/index8")
    @ResponseBody
    public User getIndex8(){
        System.out.println("index8");
        User user=new User();
        user.setUsername("Java");
        user.setPassword("最好的语言");
        return user;
    }
}
