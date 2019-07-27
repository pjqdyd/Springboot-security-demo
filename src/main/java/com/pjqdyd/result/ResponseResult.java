package com.pjqdyd.result;

import lombok.Data;

/**   
 * @Description:  [用于返回给前端的结果数据对象]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Data
public class ResponseResult {

    //响应的状态码
    private Integer code;

    //响应的消息
    private String message;

    //响应的数据
    private Object data;

    //默认成功的返回数据对象
    public static ResponseResult success(Object data){
        return new ResponseResult(data);
    }

    //成功返回的数据对象
    public static ResponseResult success(Integer code, Object data){
        return new ResponseResult(code, "SUCCESS", data);
    }

    //默认失败的返回对象
    public static ResponseResult error(){
        return new ResponseResult(201,"Fail", null);
    }

    //失败的返回对象
    public static ResponseResult error(Integer code, String message){
        return new ResponseResult(code, message,null);
    }

    //默认成功的构造器
    public ResponseResult(Object data){
        this.code = 200;
        this.message = "SUCCESS";
        this.data = data;
    }
    //默认构造器
    public ResponseResult(Integer code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
