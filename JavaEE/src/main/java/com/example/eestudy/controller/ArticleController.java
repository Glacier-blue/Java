package com.example.eestudy.controller;


import com.example.eestudy.model.Article;
import com.example.eestudy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/article")
@ResponseBody
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("getAll")
    public List<Article> selectAll(){
        return articleService.selectAll();
    }
}
