package com.hfl.web;

import com.hfl.dto.LeafDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("password","123456");
        model.addAttribute("sss","123");
        return "/web/index";
    }


    @RequestMapping(value = "indexLeaf", method = RequestMethod.GET)
    public String indexLeaf(Model model) {
        model.addAttribute("name", "胡方雷");
        model.addAttribute("age", 29);
        return "/web/index";
    }

    @RequestMapping(value = "indexLeaf/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<LeafDto> list = new ArrayList<LeafDto>();
        list.add(new LeafDto("知识林", "http://www.zslin.com"));
        list.add(new LeafDto("项目基础", "http://basic.zslin.com"));
        model.addAttribute("datas", list);
        return "/web/list";
    }
}
