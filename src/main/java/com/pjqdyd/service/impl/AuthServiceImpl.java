package com.pjqdyd.service.impl;

import com.pjqdyd.entity.User;
import com.pjqdyd.enums.ResultEnum;
import com.pjqdyd.exception.CustomException;
import com.pjqdyd.repository.UserRepository;
import com.pjqdyd.service.AuthService;
import com.pjqdyd.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**   
 * @Description:  [认证服务接口实现类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;


    /**
     * 用户注册
     * @param userToAdd 用户实体
     * @return 结果
     */
    @Override
    public User register(User userToAdd) {
        final String username = userToAdd.getUsername();
        if (userRepository.findByUsername(username) != null) { //用户已存在
           throw new CustomException(ResultEnum.USER_ALREADY_EXISTS);
        }
        //密码按照security默认加密方式
        final String rawPassword = new BCryptPasswordEncoder().encode(userToAdd.getPassword());
        userToAdd.setPassword(rawPassword);
        return userRepository.save(userToAdd);
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public String login(String username, String password) {
        //用户验证
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);

        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //加载用户信息
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        //根据用户信息生成token并返回
        return jwtTokenUtil.generateToken(userDetails);
    }
}
