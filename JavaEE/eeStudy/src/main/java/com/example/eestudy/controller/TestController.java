package com.example.eestudy.controller;


import com.example.eestudy.config.AppConfig;
import com.example.eestudy.model.People;
import com.example.eestudy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    //注入方式1：使用注解注入（最多使用）
    //@Autowired
    private  TestService testService;

    //注入方式2：使用setter注入
    @Autowired
    public void setTestService(TestService testService){
        this.testService=testService;
    }
    //注入方式3：使用构造器注入（推荐使用）
//    public TestController(TestService testService) {
//        this.testService = testService;
//    }


    public void function(){
        testService.say();
    }

    //注册方式2
    @Bean
    public People function2(){
        People people=new People();
        people.setName("abc");
        people.setPassword("123");
        return people;
    }

    @Bean
    public People function3(){
        People people1=new People();
        people1.setName("zzz");
        people1.setPassword("aaa");
        return people1;
    }

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        TestController testController=context.getBean(TestController.class);
        System.out.println(testController);
        testController.function();
        People people= (People) context.getBean("people");
        System.out.println(people);
        System.out.println(people);
        People people1=context.getBean("people",People.class);
        System.out.println(people1);
        AppConfig config=context.getBean(AppConfig.class);
        System.out.println(config);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
