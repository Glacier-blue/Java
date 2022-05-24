package com.example.eestudy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//注册方式3
@Configuration
public class AppConfig implements WebMvcConfigurer {
    private final Logger logger= LoggerFactory.getLogger(AppConfig.class);

    //静态资源放行
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("file:"+"D:\\wangfuming\\Desktop\\upload\\");
        registry.addResourceHandler("/view/**")
                .addResourceLocations("file:"+"D:\\Github\\View\\");
        registry.addResourceHandler("/start/**").addResourceLocations("classpath:/start/");
    }


    //    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("api",c->true);
//    }
//
    //拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("拦截器启动");
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
//    }
}
