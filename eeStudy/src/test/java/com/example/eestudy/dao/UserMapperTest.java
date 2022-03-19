package com.example.eestudy.dao;

import com.example.eestudy.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void add() {
        User user=new User();

//        user.setUsername("wfm");
//        user.setPassword("qwe123");
//        user.setPhoto("/test");

//        user.setUsername("qqq");
//        user.setPassword("123456");
//        user.setPhoto("/test");


        int res = userMapper.add(user);
        System.out.println(user);
        System.out.println(res);
    }

    @Test
    void selectById() {
        User user=userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void selectByNameAndPassword() {
        String name="wfm";
        String password="qwe123";
        User user=userMapper.selectByNameAndPassword(name,password);
        System.out.println(user);
    }

    @Test
    void getAll() {
        List<User> users=userMapper.getAll();
        for (User u: users) {
            System.out.println(u);
        }
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByName() {
        String name="qqq";
        List<User> users=userMapper.findByName(name);
        for (User u: users) {
            System.out.println(u);
        }
    }

    @Test
    void getFullUser() {
        int id  = 1;
        User user=userMapper.getFullUser(id);
        System.out.println(user);
    }
}