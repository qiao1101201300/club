package com.graduate.club.entity;

import lombok.Data;

@Data
public class UserClub extends BaseEntity {

    /**
     * 用户id
     */
    private String userid;

    /**
     * 社团id
     */
    private String clubid;

    /**
     * 职务
     */
    private String position;

    /**
     * 状态(0:初始;1:审核;2参与)
     */
    private Integer status;

}