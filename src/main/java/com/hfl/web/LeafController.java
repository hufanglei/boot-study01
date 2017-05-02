package com.hfl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hfl on 2017-5-2.
 * thymyleaf测试controller
 */
@Controller
public class LeafController {

    @GetMapping(value = "leaf")
    public String index(Model model, HttpServletRequest request) {
        return "/web/index";
    }

    @GetMapping(value = "leaf2")
    public String leaf(Model model, HttpServletRequest request) {
        List<String> datas = new ArrayList<String>();
        datas.add("知识林");
        datas.add("http://www.zslin.com");
        datas.add("393156105");
        model.addAttribute("datas", datas);
        model.addAttribute("curDate", new Date());

        model.addAttribute("money", Math.random()*100);
        return "/web/index";
    }
}
