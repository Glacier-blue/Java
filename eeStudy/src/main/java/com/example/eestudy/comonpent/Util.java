package com.example.eestudy.comonpent;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Util {
    private int count=0;
    @Scheduled(cron = "0/3 * * * * ?")
    public String doTask(){
        count++;
        return "第"+count+"次执行任务";
    }
}
