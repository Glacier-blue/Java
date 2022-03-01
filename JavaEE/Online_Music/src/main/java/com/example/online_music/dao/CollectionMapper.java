package com.example.online_music.dao;

import com.example.online_music.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface CollectionMapper {
    int addLoveMusic(int userId,int musicId);
    int removeLoveMusic(int userId,int musicId);
    Music findLoveMusicById(int userId,int musicId);
    List<Music> ifMusicLove(String str, int userId);
    List<Music> findLoveMusic(int userId);
}
