package com.hfl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hfl on 2017-4-27.
 * 1.在@Value的${}中包含的是核心配置文件中的键名。在Controller类上加@RestController表示将此类中的所有视图都以JSON方式显示，类似于在视图方法上加@ResponseBody。
 * 2.这种方式是依赖注入Evnironment来完成，在创建的成员变量private Environment env上加上@Autowired注解即可完成依赖注入，然后使用env.getProperty("键名")即可读取出对应的值。
 */
@RestController
public class WebController {

    //1.在@Value的${}中包含的是核心配置文件中的键名。在Controller类上加@RestController表示将此类中的所有视图都以JSON方式显示，类似于在视图方法上加@ResponseBody。
    @Value("${test.msg}")
    private String msg;


    //2.这种方式是依赖注入Evnironment来完成，在创建的成员变量private Environment env上加上@Autowired注解即可完成依赖注入，然后使用env.getProperty("键名")即可读取出对应的值。
    @Autowired
    private Environment env;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "The Way 1 : " +msg;
    }

    @RequestMapping(value = "index2", method = RequestMethod.GET)
    public String index2() {
        return "The Way 2 : " +env.getProperty("test.msg");
    }
}
