package com.pjqdyd.service.impl;

import com.pjqdyd.entity.User;
import com.pjqdyd.service.AuthService;
import com.pjqdyd.service.UserService;
import com.pjqdyd.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**   
 * @Description:  [认证服务实现]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserService userService;

    @Resource
    private AuthenticationManager authenticationManager;


    @Override
    public User register(User user) {
        return null;
    }

    /**
     * 登录方法, 登录成功后返回封装的token
     * @param username 用户名
     * @param password 密码
     * @return String token
     */
    @Override
    public String login(String username, String password) {
        //用户验证
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);

        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //加载用户信息
        final User user = userService.getUserByName(username);

        //根据用户信息生成token并返回
        return jwtTokenUtil.generateToken(user);
    }
}
