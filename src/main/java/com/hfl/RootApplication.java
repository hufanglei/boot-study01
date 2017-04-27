package com.hfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by hfl on 2017-4-27.
 * 程序入口
 */
@SpringBootApplication
@EnableScheduling

public class RootApplication {

    public static void main(String [] args) {
        SpringApplication.run(RootApplication.class, args);
    }

}
