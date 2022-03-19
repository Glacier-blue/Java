package com.example.eestudy.model;


import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private int id;
    private String title;
    private String content;
    private Date createtime;
    private Date updatetime;
    private int uid;
    private int count;
    private String state;
    private User user;
}
