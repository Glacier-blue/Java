package com.example.springloc;


import com.example.springloc.config.AppConfig;
import com.example.springloc.controller.LoginController;
import com.example.springloc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //注入1：获取1
        com.example.springloc.controller.LoginController loginController= (LoginController) context.getBean("loginController");
        System.out.println(loginController);
        //注入2：获取1
        User user1= (User) context.getBean("user1");
        System.out.println(user1);
        //注入2：获取2
        User user2=context.getBean("user1",User.class);
        System.out.println(user2);
        //注入3：获取1
        AppConfig config=context.getBean(AppConfig.class);
        System.out.println(config);

        loginController.say();



        ((ClassPathXmlApplicationContext)context).close();
    }
}
