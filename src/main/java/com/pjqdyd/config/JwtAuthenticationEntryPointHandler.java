package com.pjqdyd.config;

import com.pjqdyd.enums.ResultEnum;
import com.pjqdyd.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**   
 * @Description:  [匿名用户访问无权限资源时的异常处理类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */
@Slf4j
@Component
public class JwtAuthenticationEntryPointHandler implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        //验证为未登陆状态会进入此方法，认证错误
        log.error("匿名用户认证失败 = {}", authException.getMessage());
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        //返回给前端的结果
        ResponseResult responseResult = new ResponseResult(ResultEnum.AUTHENTICATION_FAILED.getCode(), "匿名用户认证失败", null);
        String body = responseResult.toString();
        printWriter.write(body);
        printWriter.flush();
    }
}
