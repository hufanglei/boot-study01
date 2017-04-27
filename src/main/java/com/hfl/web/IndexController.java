package com.hfl.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hfl on 2017-4-27.
 */
@RestController
public class IndexController {


    @RequestMapping(value = "index")
    public String index() {

        return "Hello World!!!";
    }

}
