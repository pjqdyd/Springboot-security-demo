package com.pjqdyd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试")
@RestController
public class MainController {

    /**
     * 返回主页
     */
    @ApiOperation(value = "test")
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
