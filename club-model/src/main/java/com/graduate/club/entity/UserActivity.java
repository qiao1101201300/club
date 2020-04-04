package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserActivity extends BaseEntity {

    /**
     * 用户id
     */
    @NotBlank(message = "用户id不能为空")
    private String userid;

    /**
     * 活动id
     */
    @NotBlank(message = "活动id不能为空")
    private String actid;

    /**
     * 状态(0:初始;1:审核;2参与)
     */
    private Integer status;

}