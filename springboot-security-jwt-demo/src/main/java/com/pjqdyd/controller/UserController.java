package com.pjqdyd.controller;

import com.pjqdyd.enums.ResultEnum;
import com.pjqdyd.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @Description:  [用户Controller层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    public ResponseResult hello(){
        return ResponseResult.success(ResultEnum.SUCCESS.getCode(), "hello");
    }

}
