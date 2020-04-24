package com.pjqdyd.controller;

import com.pjqdyd.enums.ResultEnum;
import com.pjqdyd.result.ResponseResult;
import com.pjqdyd.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**   
 * @Description:  [认证Controller层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    /**
     * 登录接口
     * @return String token
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestParam("username") String username, @RequestParam("password") String password){
            String token =  authService.login(username, password);
        return ResponseResult.success(ResultEnum.SUCCESS.getCode(), token);
    }

}
