package com.example.online_music.controller;


import com.example.online_music.dao.UserMapper;
import com.example.online_music.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    private final Logger logger= LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login")
    @ResponseBody
    public Object login(User user, HttpServletRequest req){
        Map<String,Object> map=new HashMap<>();
        User user1=userMapper.findUserByName(user.getUsername());
        if(user1==null||!user1.getPassword().equals(user.getPassword())){
            map.put("msg",false);
            logger.info("登录失败，用户名以及密码为："+user.getUsername()+" "+user.getPassword());
        }else{
            map.put("msg",true);
            logger.info("登陆成功");
            HttpSession session=req.getSession();
            session.setAttribute("user",user1);
        }
        return map;
    }

}
