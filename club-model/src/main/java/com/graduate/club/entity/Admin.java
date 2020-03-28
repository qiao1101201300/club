package com.graduate.club.entity;

import lombok.Data;

@Data
public class Admin extends BaseEntity {

    /**
     * 管理员名称
     */
    private String name;

    /**
     * 管理员账号
     */
    private String username;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 管理员状态
     */
    private Integer status;

}