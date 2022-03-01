package com.example.online_music.controller;


import com.example.online_music.component.FinalVar;
import com.example.online_music.dao.CollectionMapper;
import com.example.online_music.dao.MusicMapper;
import com.example.online_music.model.Music;
import com.example.online_music.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/music")
@Controller
@ResponseBody
public class MusicController {

    private final MusicMapper musicMapper;
    private final CollectionMapper collectionMapper;

    private Logger logger= LoggerFactory.getLogger(MusicController.class);

    public MusicController(MusicMapper musicMapper, CollectionMapper collectionMapper) {
        this.musicMapper = musicMapper;
        this.collectionMapper = collectionMapper;
    }


    @RequestMapping("/upload")
    public void uploadMusic(HttpServletResponse resp,HttpServletRequest req, @RequestPart("filename") MultipartFile file) throws IOException {
        User user= (User) req.getSession().getAttribute("user");
        if(user==null){
            req.setAttribute("msg","登陆后上传");
            resp.setStatus(301);
            resp.sendRedirect("/login.html");
        }else{
            String path= FinalVar.APP_PATH+"/music/";
            String fileType=file.getOriginalFilename();
            assert fileType != null;
            String name=fileType.substring(0,fileType.lastIndexOf("."));
            fileType=fileType.substring(fileType.lastIndexOf("."));
            String fileName= UUID.randomUUID() +fileType;
            req.getSession().setAttribute("name",name);
            req.getSession().setAttribute("url",fileName);
            file.transferTo(new File(path+fileName));
            resp.setStatus(301);
            resp.sendRedirect("/uploadsucess.html");
        }
    }

    @RequestMapping("/uploadsucess")
    public void sucess(String singer,HttpServletResponse resp,HttpServletRequest req) throws IOException {
        String newName = (String)req.getSession().getAttribute("url");
        String strings= (String) req.getSession().getAttribute("name");
        String[] titles = strings.split("\\.");
        String[] tmp=newName.split("\\.");
        String title = titles[0];
        String url = "music/"+tmp[0];
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(new Date());
        musicMapper.addMusic(title,singer,time,userId,url);
        resp.sendRedirect("/list.html");
    }

    @RequestMapping("/delete")
    public Object deleteById(Integer id){
        Map<String,Object> map=new HashMap<>();
        Music music=musicMapper.findMusicById(id);
        int res = musicMapper.deleteMusic(id);
        if(res==0){
            map.put("msg",false);
        }else{
            File file=new File(FinalVar.APP_PATH+"//"+music.getUrl()+".mp3");
            if(file.delete()){
                map.put("msg",true);
            }else{
                map.put("msg",false);
            }
        }
        return map;
    }
    @RequestMapping("/delSelMusic")
    public Object delSelMusic(@RequestParam("id[]") Integer[] id){
        int sum=0;
        Map<String,Object> map=new HashMap<>();
        for (int j : id) {
            System.out.println("j :" + j);
            Music music = musicMapper.findMusicById(j);
            int res = musicMapper.deleteMusic(j);
            if (res > 0) {
                File file = new File(FinalVar.APP_PATH +"\\" +music.getUrl() + ".mp3");
                System.out.println("文件是否存在：" + file.exists());

                if (file.delete()) {
                    sum++;
                } else {
                    System.out.println("文件名：" + file.getName());
                    System.out.println("删除文件失败！");
                }
            }
        }
        if(sum==id.length){
            map.put("msg",true);
        }else {
            map.put("msg",false);
        }
        return map;
    }

    @RequestMapping("/findMusic")
    public Object findMusic(String musicName){
        List<Music> list;
        if(musicName==null){
            list = musicMapper.findAllMusic();
        }else{
            list = musicMapper.ifMusic(musicName);
        }
        return list;
    }

    @RequestMapping("/loveMusic")
    public Object loveMusic(Integer id,HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");
        if(user==null){

        }
        Music findMusic=collectionMapper.findLoveMusicById(user.getId(),id);
        HashMap<String,Object> map=new HashMap<>();
        if(findMusic!=null){
            map.put("msg",false);
        }else{
            int res  = collectionMapper.addLoveMusic(user.getId(),id);
            map.put("msg",res>0);
        }
        logger.info("已经存在的数据:"+findMusic+"数据："+id);
        return map;
    }

    @RequestMapping("/findLoveMusic")
    public Object findLoveMusic(String loveMusicName, HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");
        List<Music> list;
        if(loveMusicName==null){
            list = collectionMapper.findLoveMusic(user.getId());
        }else{
            list = collectionMapper.ifMusicLove(loveMusicName,user.getId());
        }
        return list;
    }
    @RequestMapping("/removeLoveMusic")
    public Object removeMusic(String id,HttpServletRequest req){
        int num=Integer.parseInt(id);
        User user= (User) req.getSession().getAttribute("user");
        Map<String,Object> map=new HashMap<>();
        int ret = collectionMapper.removeLoveMusic(user.getId(),num);
        if(ret>0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }
}
