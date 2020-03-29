package com.graduate.club.entity;

import lombok.Data;

@Data
public class User extends BaseEntity {
    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 用户状态
    */
    private Integer status;

    private String random;

}