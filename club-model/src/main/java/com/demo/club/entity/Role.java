package com.demo.club.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "t_role")
public class Role extends BaseEntity {

    /**
     * 权限名称
     */
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "`status`")
    private Integer status;

    private List<Menu> menuList;
}