package com.pjqdyd.service;

import com.pjqdyd.entity.User;

/**   
 * @Description:  [认证服务接口]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public interface AuthService {

    /**
     * 用户注册方法
     * @param user 用户实体
     * @return 注册结果
     */
    User register(User user);

    /**
     * 用户登录方法
     * @param username 用户名
     * @param password 密码
     * @return Token
     */
    String login(String username, String password);
}
