package com.example.eestudy.dao;


import com.example.eestudy.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> getAll();
    List<Article> getArticle(String title,String content,int state);
    List<Article> getArticle2(String title,String content,int state);
    List<Article> getArticle3(String title,String content,int state);
    int updateArticle(Article article);
    int deleteArticleByIds(Integer[] ids);
    int delById(int id);
    Article detail(int id);
    int add(Article articleInfo);
    int addArticle(String title, String content, int uid,int count, int state);
}
