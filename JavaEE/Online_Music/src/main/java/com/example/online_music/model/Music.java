package com.example.online_music.model;

import lombok.Data;


import java.util.Date;

@Data
public class Music {
    private int id;
    private String title;
    private String singer;
    private Date time;
    private String url;
    private int userId;

}
