package com.example.online_music.dao;


import com.example.online_music.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    int addUser(User user);
    User findUserByName(String username);
}
