package com.pjqdyd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @Description:  [用户的接口资源]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String index(){
        return "用户接口";
    }

    @GetMapping("/select")
    public String select(){
        return "用户查询接口";
    }

    @PostMapping("/delete")
    public String delete(){
        return "用户删除接口";
    }

}
