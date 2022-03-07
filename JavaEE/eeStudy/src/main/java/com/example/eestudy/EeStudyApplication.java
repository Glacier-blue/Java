package com.example.eestudy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class EeStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeStudyApplication.class, args);
    }
}
