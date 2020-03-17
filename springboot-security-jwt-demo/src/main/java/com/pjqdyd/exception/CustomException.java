package com.pjqdyd.exception;

import com.pjqdyd.enums.ResultEnum;

/**   
 * @Description:  [自定义异常]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

public class CustomException extends RuntimeException{

    //错误码
    private Integer errorCode;

    //异常构造器(参数为结果枚举)
    public CustomException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.errorCode = resultEnum.getCode();
    }

    //异常构造器
    public CustomException(Integer errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return this.errorCode == null ? 201 :this.errorCode;
    }

}
