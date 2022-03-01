package com.example.eestudy.dao;

import com.example.eestudy.model.Article;
import com.example.eestudy.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int add(User user);
    User selectById(int id);
    //多个参数需要保证映射一致，不一致可以使用@Param实现一致
//    User selectByNameAndPassword(@Param("name") String username, String password);
    User selectByNameAndPassword(String username, String password);
    List<User> getAll();
    int deleteById(int id);
    int addArticle(Article article);
    List<User> findByName(String name);
    User getFullUser(int id);
}
