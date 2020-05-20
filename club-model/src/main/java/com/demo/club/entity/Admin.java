package com.demo.club.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_admin")
public class Admin extends BaseEntity {

    /**
     * 管理员名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 管理员账号
     */
    @Column(name = "username")
    private String username;

    /**
     * 管理员密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 管理员状态
     */
    @Column(name = "`status`")
    private Integer status;

}