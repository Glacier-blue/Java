package com.example.eestudy.controller;


import com.example.eestudy.model.EEException;
import com.example.eestudy.model.User;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Objects;
import java.util.UUID;

@RequestMapping("/user")
@Controller
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/message")
    @ResponseBody
    public String getIndex(){
        logger.debug("我是一个debug日志");
        logger.error("我是一个error日志");
        logger.info("我是一个info日志");
        logger.warn("我是一个warn日志");
        logger.trace("我是一个trace日志");
        return "我是logger日志信息";
    }

    /*----------------------------------------------------------------------------------------------*/
    private static final String USERNAME="username";
    private static final String PASSWORD="password";
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user, HttpServletRequest req){
        if(USERNAME.equals(user.getUsername())&&PASSWORD.equals(user.getPassword())){
            req.getSession().setAttribute("user",user);
            return "登录成功";
        }else{
            return "登录失败";
        }
    }

    /*-----------------------------------------------------------------------------------------------*/
    //文件上传
    @RequestMapping("/register")
    public Object register(String username, @RequestPart MultipartFile file) throws IOException {
        //动态获取路径
        String path= Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("static")).getPath();
        System.out.println(username);
        logger.error(path);
        path+="/upload/";
        //获取文件名字，目的是获取文件格式
        String fileType=file.getOriginalFilename();
        assert fileType != null;
        fileType=fileType.substring(fileType.lastIndexOf("."));
        String fileName= UUID.randomUUID() +fileType;
        file.transferTo(new File(path+fileName));
        return null;
    }

    @RequestMapping("/set")
    @ResponseBody
    public String setCookie(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("user",new User());
        return session.toString();
    }
    @RequestMapping("/cookie")
    @ResponseBody
    public String getCookie(@CookieValue("JSESSIONID") String id){
        return id;
    }


    @RequestMapping("/test")
    @ResponseBody
    public String error() throws EEException {
        throw new EEException("数据库操作异常");
    }

    @RequestMapping("/method")
    @ResponseBody
    public Object ret(){
        Object o="abcdefg";
        return o;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestPart("file") MultipartFile file) throws IOException {
//        String path= Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("static")).getPath();
        String path=System.getProperty("user.dir");
        logger.error(path);
        path+="/upload/";
        String fileType= file.getOriginalFilename();
        logger.info(fileType);
        assert fileType != null;
        fileType=fileType.substring(fileType.lastIndexOf("."));
        logger.info(fileType);
        String fileName= UUID.randomUUID() +fileType;
        file.transferTo(new File(path+fileName));
        return "文件上传成功";
    }
    @RequestMapping("/down")
    public ResponseEntity<byte[]> down(HttpServletRequest req,String name) throws IOException {
        String path=System.getProperty("user.dir")+"/upload/";

        HttpHeaders headers = new HttpHeaders();
        File file = new File(path+name);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", name);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

}
