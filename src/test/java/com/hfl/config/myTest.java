package com.hfl.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hfl on 2017-4-27.
 *
 * 遇到了大坑:注意 放在com.hfl下的文件下 不然报错
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class myTest {

    @Value("${test.msg}")
    private String msg;

    @Autowired
    private Environment env;


    @Test
    public void testCoreConfig(){
        System.out.println("cur msg is : "+msg);
    }

    @Test
    public void testCoreConfig2() {
        System.out.println(env.getProperty("test.msg"));
    }

}
