package com.example.eestudy.model;


import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String photo;
    private List<Article> list;
}
