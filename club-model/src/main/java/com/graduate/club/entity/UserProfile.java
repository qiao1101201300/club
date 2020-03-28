package com.graduate.club.entity;

import lombok.Data;

@Data
public class UserProfile extends BaseEntity {
    /**
     * 用户id
     */
    private String userid;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户等级（0：普通学生；1:社团管理员）
     */
    private Integer level;

    /**
     * 用户学号
     */
    private String cardno;

    /**
     * 班级
     */
    private String classname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 简介
     */
    private String introduction;

}