package com.pjqdyd.controller;

import org.springframework.web.bind.annotation.*;

/**   
 * @Description:  [管理员的接口资源]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String index(){
        return "管理员接口";
    }

    @GetMapping("/select")
    public String select(){
        return "管理员查询接口";
    }

    @PostMapping("/delete")
    public String delete(){
        return "管理员删除接口";
    }

}
