package com.pjqdyd.handler;

import com.pjqdyd.enums.ResultEnum;
import com.pjqdyd.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**   
 * @Description:  [认证过的用户访问无权限资源时的异常处理类] (在这之前的异常会被全局捕获)
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Slf4j
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        //登陆状态下，权限不足执行该方法
        log.error("访问接口={} 权限不足={}", request.getRequestURI(), e.getMessage());
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        //返回给前端的结果
        ResponseResult responseResult = new ResponseResult(ResultEnum.PERMISSION_ERROR.getCode(), "权限不足", null);
        String body = responseResult.toString();
        printWriter.write(body);
        printWriter.flush();
    }
}
