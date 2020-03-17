package com.pjqdyd.controller;

import com.pjqdyd.entity.User;
import com.pjqdyd.result.ResponseResult;
import com.pjqdyd.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**   
 * @Description:  [用户认证Controller层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 登录接口
     * @param username 用户名
     * @param password 密码
     * @return 登录结果
     */
    @PostMapping("/login")
    public ResponseResult createToken(String username, String password) {
        String token = authService.login(username, password);
        return ResponseResult.success(token);
    }

    /**
     * 注册接口
     * @param addedUser 注册用户
     * @return 注册成功返回的结果
     */
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User addedUser) {
        User user = authService.register(addedUser);
        return ResponseResult.success(user);
    }

}
