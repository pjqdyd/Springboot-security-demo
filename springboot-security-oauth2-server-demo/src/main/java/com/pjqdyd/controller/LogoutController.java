package com.pjqdyd.controller;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**   
 * @Description:  [注销登录Controller层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@RestController
@RequestMapping("/logout")
public class LogoutController {

    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    @Resource
    private TokenStore tokenStore;

    @Resource
    private HttpServletRequest request;

    /**
     * 用户注销
     * @return
     */
    @PostMapping("/user")
    public String user(){
        return logout();
    }

    private String logout(){
        String authHeader = request.getHeader(TOKEN_HEADER); //获取前端请求头传入的Authorization
        if (authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
            final String accessToken = authHeader.substring(TOKEN_PREFIX.length()); //获取传入的access_token
            final OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
            if (oAuth2AccessToken != null){
                tokenStore.removeAccessToken(oAuth2AccessToken); //删除数据库中的access_token
                return "注销成功!";
            }
        }
        return "注销Token不存在";
    }
}
