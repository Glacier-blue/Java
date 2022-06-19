package com.example.eestudy.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// UserController AOP 实现示例
@Aspect
@Component
public class UserAspect {
    //  第一个*表示返回值
    //  第二个*表示方法名
    //  两个.表示参数
    @Pointcut("execution(* com.example.eestudy.controller.UserController.*(..))")
    public void pointcut(){

    }
}
