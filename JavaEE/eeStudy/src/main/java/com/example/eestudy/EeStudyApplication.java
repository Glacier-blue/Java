package com.example.eestudy;

import com.example.eestudy.config.AppConfig;
import com.example.eestudy.controller.TestController;
import com.example.eestudy.model.People;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class EeStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeStudyApplication.class, args);
    }
}
