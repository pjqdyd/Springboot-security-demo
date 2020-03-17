package com.pjqdyd.controller;

import com.pjqdyd.result.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试")
@RestController
public class MainController {

    /**
     * 返回主页
     */
    @ApiOperation(value = "主页接口")
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 测试普通用户权限
     * @return 结果
     */
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user/test")
    public ResponseResult test1() {
        return ResponseResult.success("/ROLE_USER 用户接口调用成功");
    }

    /**
     * 测试管理员权限
     * @return 结果
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/test")
    public ResponseResult test2() {
        return ResponseResult.success("/ROLE_ADMIN 管理员接口调用成功");
    }

    /**
     * 测试超级管理员权限
     * @return 结果
     */
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping("/superAdmin/test")
    public ResponseResult test3() {
        return ResponseResult.success("/ROLE_SUPER_ADMIN 超级管理员接口调用成功");
    }

}
