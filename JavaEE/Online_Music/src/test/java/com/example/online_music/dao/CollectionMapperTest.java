package com.example.online_music.dao;

import com.example.online_music.model.Music;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CollectionMapperTest {

    @Autowired
    private CollectionMapper collectionMapper;
    @Test
    void ifMusicLove() {
        List<Music> music=collectionMapper.ifMusicLove("name",1);
        for(Music m:music){
            System.out.println(m);
        }
    }

    @Test
    void findLoveMusic() {
        List<Music> musicList=collectionMapper.findLoveMusic(1);
        for(Music m:musicList){
            System.out.println(m);
        }
    }

    @Test
    void findLoveMusicById() {
        Music music=collectionMapper.findLoveMusicById(1,15);
        System.out.println(music);
    }

    @Test
    void removeLoveMusic() {
        int res = collectionMapper.removeLoveMusic(1,19);
        System.out.println(res);
    }

    @Test
    void addLoveMusic() {
//        int res = collectionMapper.addLoveMusic(1,17);
//        int res = collectionMapper.addLoveMusic(1,18);
//        int res = collectionMapper.addLoveMusic(1,19);
        int res = collectionMapper.addLoveMusic(1,20);
        System.out.println(res);
    }
}