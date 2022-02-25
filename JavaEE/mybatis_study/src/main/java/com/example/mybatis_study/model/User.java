package com.example.mybatis_study.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String username;
    private String password;
    private String photo;
    private Date createtime;
    private Date updatetime;
    private int state;
}
