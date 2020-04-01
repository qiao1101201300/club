package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Admin extends BaseEntity {

    /**
     * 管理员名称
     */
    private String name;

    /**
     * 管理员账号
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 管理员密码
     */
    @NotBlank(message ="密码不能为空")
    private String password;

    /**
     * 管理员状态
     */
    private Integer status;

}