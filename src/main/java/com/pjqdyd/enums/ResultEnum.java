package com.pjqdyd.enums;

import lombok.Getter;

/**   
 * @Description:  [状态结果枚举 : 给前端提示消息的枚举/设置给自定义异常的枚举]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Getter
public enum ResultEnum implements EnumInfoGetter {

    /****** Global *****/
    SUCCESS(200, "SUCCESS"),
    FAIL(201, "FAIL"),
    PARAM_ERROR(202, "参数错误"),
    TYPE_CONVER_ERROR(203,"类型转换错误"),
    LOGIN_ERROR(204,"登录错误"),
    SQL_ERROR(205, "数据库SQL异常"),
    UNKNOWN_ERROR(206, "未知错误"),
    PERMISSION_ERROR(207, "权限不足");

    private Integer code;
    private String message;

    //自身的构造器
    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
