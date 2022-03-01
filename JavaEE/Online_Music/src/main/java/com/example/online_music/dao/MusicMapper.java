package com.example.online_music.dao;


import com.example.online_music.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MusicMapper {
    int addMusic(String title,String singer,String time,int userId,String url);
    int deleteMusic(int id);
    List<Music> findAllMusic();
    Music findMusicById(int id);
    List<Music> ifMusic(String name);

}
