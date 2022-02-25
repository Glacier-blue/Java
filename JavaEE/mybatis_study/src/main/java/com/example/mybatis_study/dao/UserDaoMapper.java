package com.example.mybatis_study.dao;

import com.example.mybatis_study.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDaoMapper {
    public int add(User user);
}
