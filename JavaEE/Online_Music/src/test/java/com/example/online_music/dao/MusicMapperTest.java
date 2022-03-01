package com.example.online_music.dao;

import com.example.online_music.model.Music;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootTest
class MusicMapperTest {

    @Autowired
    private MusicMapper musicMapper;
    @Test
    void addMusic() {
        Music music=new Music();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(new Date());
//        music.setSinger("author1");
//        music.setTitle("name1");
//        music.setUrl("/test1");
//        music.setUserId(1);

//        music.setSinger("author2");
//        music.setTitle("name2");
//        music.setUrl("/test2");
//        music.setUserId(1);

        music.setSinger("author2");
        music.setTitle("name3");
        music.setUrl("/test3");
        music.setUserId(1);
        int res = musicMapper.addMusic(music.getTitle(), music.getSinger(),time, music.getUserId(), music.getUrl());
        System.out.println(res);
    }

    @Test
    void deleteMusic() {
        int res  = musicMapper.deleteMusic(12);
        System.out.println(res);
    }

    @Test
    void findAllMusic() {
        List<Music> musicList=musicMapper.findAllMusic();
        for(Music m:musicList){
            System.out.println(m);
        }
    }

    @Test
    void findMusicById() {
        int id = 17;
        Music music=musicMapper.findMusicById(id);
        System.out.println(music);
    }

    @Test
    void ifMusic() {
        String name="胡歌";
        List<Music> musics=musicMapper.ifMusic(name);
        for(Music m:musics){
            System.out.println(m);
        }
    }
}