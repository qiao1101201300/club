package com.graduate.club.entity;

import lombok.Data;

@Data
public class UserActivity extends BaseEntity {

    /**
     * 用户id
     */
    private String userid;

    /**
     * 活动id
     */
    private String actid;

    /**
     * 状态(0:初始;1:审核;2参与)
     */
    private Integer status;

}