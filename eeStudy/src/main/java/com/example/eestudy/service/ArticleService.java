package com.example.eestudy.service;

import com.example.eestudy.dao.ArticleMapper;
import com.example.eestudy.model.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final Logger logger= LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Cacheable(cacheNames = "List<Article>",key = "")
    public List<Article> selectAll(){
        logger.info("进入查找所有函数函数");
        return articleMapper.getAll();
    }

}
