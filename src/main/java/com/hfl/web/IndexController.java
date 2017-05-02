package com.hfl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hfl on 2017-4-27.
 * @Controller：只出现在类名上，表示该类为控制器，默认的控制器名称就是类名indexController
 * return "/web/index"：指定视图文件，根据application.properties中配置的前缀与后缀可以得出这里的视图文件
 *
 */
@Controller
public class IndexController {


    @RequestMapping(value = "hello")
    public String index(Model model) {
        model.addAttribute("name","胡方雷");
        return "/web/index";
    }

}
