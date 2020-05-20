package com.demo.club.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_role_menu")
public class RoleMenu extends BaseEntity{

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "menu_id")
    private String menuId;

}