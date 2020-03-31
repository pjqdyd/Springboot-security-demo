package com.pjqdyd.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**   
 * @Description:  [自定义的过滤器, 可以打印访问者的信息]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Slf4j
public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("请求者SESSION_ID:{}, 访问的接口:{}", request.getSession().getId(), request.getRequestURI());
        filterChain.doFilter(request, response); //将请求交给下面的过滤器
    }
}
