package com.example.eestudy.dao;

import com.example.eestudy.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;




@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;
    @Test
    void getAll() {
        List<Article> articles=articleMapper.getAll();
        for (Article a: articles) {
            System.out.println(a);
        }
    }

    @Test
    void getArticle() {
        List<Article> articles=articleMapper.getArticle("文章1",null,0);
        for (Article a: articles) {
            System.out.println(a);
        }
    }


    @Test
    void getArticle2() {
        List<Article> articles=articleMapper.getArticle2("文章1",null,0);
        for (Article a: articles) {
            System.out.println(a);
        }
    }

    @Test
    void getArticle3() {
        List<Article> articles=articleMapper.getArticle3("文章1",null,0);
        for (Article a: articles) {
            System.out.println(a);
        }
    }

    @Test
    void updateArticle() {
    }

    @Test
    void deleteArticleByIds() {
    }

    @Test
    void testUpdateArticle() {
        Article article=new Article();
        article.setId(1);
        article.setTitle("今天是星期一");
        article.setContent("明天三月一号");
        int res = articleMapper.updateArticle(article);
        System.out.println(res);
    }

    @Test
    void testDeleteArticleByIds() {
    }
}