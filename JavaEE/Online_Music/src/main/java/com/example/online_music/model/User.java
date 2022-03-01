package com.example.online_music.model;


import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int age;
    private String gender;
    private String email;
}
