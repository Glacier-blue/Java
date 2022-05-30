package book_mananger.controller;

import book_mananger.dao.UserDao;
import book_mananger.model.User;

import java.util.Scanner;

public class UserController {
    public User login(String sid, String password){
        User user = UserDao.selectBySID(sid);
        if(user==null||!user.password.equals(password)){
            System.out.println("登录失败！请检查账号密码");
            return null;
        }else{
            System.out.println("登录成功");
            return user;
        }
    }
    public User register(){
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("msg:请输入学号以及密码，请注意如下\n1、学号具有唯一性\n2、账号密码不能为空\n3、按照提示输入账号密码");
        System.out.print("账号>>>");
        user.sid = scanner.nextLine();
        System.out.print("姓名>>>");
        user.name = scanner.nextLine();
        System.out.print("密码>>>");
        user.password = scanner.nextLine();
        if(UserDao.add(user)){
            return user;
        }else{
            return null;
        }
    }
}
