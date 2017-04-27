package com.hfl.timer;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hfl on 2017-4-27.
 *  需要在定时任务的类上加上注释：@Component，在具体的定时任务方法上加上注释@Scheduled即可启动该定时任务。
 */
//@Component
public class MyTimer {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(fixedRate = 3000)
    public void timerRate() {
        System.out.println(sdf.format(new Date()));
    }

    //第一次延迟1秒执行，当执行完后3秒再执行
    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    public void timerInit() {
        System.out.println("init : "+sdf.format(new Date()));
    }

    //每天23点27分50秒时执行
    @Scheduled(cron = "50 27 23 * * ?")
    public void timerCron() {
        System.out.println("current time : "+ sdf.format(new Date()));
    }

}
