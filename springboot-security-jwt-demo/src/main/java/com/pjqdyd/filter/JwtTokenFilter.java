package com.pjqdyd.filter;

import com.pjqdyd.service.impl.UserDetailsServiceImpl;
import com.pjqdyd.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**   
 * @Description:  [Jwt token拦截过滤器]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */
@Slf4j
//@Component //(因为在security中已经注册了这个过滤器, 重复注入可能会拦截2次)
public class JwtTokenFilter extends OncePerRequestFilter {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Value("${jwt.header}")
    private String TOKEN_HEADER;

    @Value("${jwt.token-prefix}")
    private String TOKEN_PREFIX;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(TOKEN_HEADER); //获取前端请求头传入的token

        if (authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
            final String authToken = authHeader.substring(TOKEN_PREFIX.length());

            //从token中解析用户名和权限信息, 如果正确解析且没过期就代表验证token成功
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            String perms = jwtTokenUtil.getPermsFromToken(authToken);
            log.info("检查认证信息 用户名={} 权限={} 访问接口={}", username, perms, request.getRequestURI());

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //根据Token中获取用户的权限名称集合, 生成权限集合, 方便security认证
                List<String> permNameList = Arrays.asList(perms.split(","));
                List<GrantedAuthority> grantedAuthorities = userDetailsServiceImpl.getGrantedAuthoritiesList(permNameList);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                username, null, grantedAuthorities);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //认证的结果信息交给Spring security
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
