package com.hfl.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hfl on 2017-4-27.
 *
 * @ActiveProfiles("test")，加上这个注释就表示现在使用application-test.properties这个配置文件，
 * 同样换成dev也就是使用application-dev.properties中的配置。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MyTest2 {

    @Value("${test.msg}")
    private String msg;

    @Test
    public void testConfig() {
        System.out.println("cur msg is : "+ msg);
    }

}
