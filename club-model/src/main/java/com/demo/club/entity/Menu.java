package com.demo.club.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_menu")
public class Menu extends BaseEntity{

    /**
     * 权限名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 父类id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 权限标识
     */
    @Column(name = "perms")
    private String perms;

}