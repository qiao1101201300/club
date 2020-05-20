package com.demo.club.enums;

/**
 * @Description: ${todo}
 * @Author:Frederic-QS
 */
public enum ResultEnum implements BaseEnum {

    //通用
    SUCCESS(200, "成功"),
    ERROR(400, "失败"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    DB_ERROR(501, "数据库错误"),

    //用户登录相关
    NOT_LOGIN(101, "用户未登录"),
    TOKEN_ERROR(102, "Token失效或错误"),
    USER_NOT_FOUND(103, "用户不存在"),
    PASSWORD_ERROR(104, "密码错误"),
    USERNAME_EXISTS(105, "用户名已存在"),
    PASSWORD_SAME_AS_OLDPASS(106, "新密码与原来密码相同"),
    USER_FORBID(107, "用户被禁用"),
    TOKEN_EXPIRED(108, "Token过期"),
    USERNAME_NOT_EXISTS(110, "用户未登记资料"),

    //参数校验相关
    PARAM_ERROR(301, "参数错误"),
    PARAM_NOT_FOUND(302, "参数未找到"),
    DB_SAVE_FAILED(303, "数据保存失败"),
    SYNC_FAILED(304, "数据同步失败");

    private String msg;
    private int code;

    ResultEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
