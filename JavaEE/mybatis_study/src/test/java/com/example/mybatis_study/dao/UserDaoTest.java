package com.example.mybatis_study.dao;

import com.example.mybatis_study.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {


    @Autowired
    private UserDaoMapper userDaoMapper;
    @Test
    void add() {
        User user=new User();
        user.setUsername("wfm");
        user.setPassword("123");
        int res =userDaoMapper.add(user);
        System.out.println(res);
    }
}