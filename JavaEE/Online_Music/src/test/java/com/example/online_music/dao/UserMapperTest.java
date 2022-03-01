package com.example.online_music.dao;

import com.example.online_music.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void addUser() {
        User user=new User();
        user.setUsername("test");
        user.setPassword("123");
        user.setAge(18);
        user.setGender("男");
        user.setEmail("/test@xd.com");
        int res=userMapper.addUser(user);
        System.out.println(res);
    }

    @Test
    void findUserByName() {
        String name="test";
        User user=userMapper.findUserByName(name);
        System.out.println(user);
    }
}