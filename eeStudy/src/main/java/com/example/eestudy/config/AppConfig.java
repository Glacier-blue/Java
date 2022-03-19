package com.example.eestudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//注册方式3
@Configuration
public class AppConfig implements WebMvcConfigurer {
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("api",c->true);
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("拦截器启动");
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
//    }
}
