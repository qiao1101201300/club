package com.graduate.club.enums;

public enum RoleEnum implements BaseEnum {

    ORDINARYADMIN(0, "普通用户"),
    CLUBMADMIN(1, "社团管理员"),
    SYSTEMADMIN(2, "系统管理员");

    private String msg;
    private int code;

    RoleEnum(int code, String msg) {
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
