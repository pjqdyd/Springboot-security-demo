package com.pjqdyd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /**
     * 返回主页
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
