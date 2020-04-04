package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserClub extends BaseEntity {

    /**
     * 用户id
     */
    @NotBlank(message = "用户id不能为空")
    private String userid;

    /**
     * 社团id
     */
    @NotBlank(message = "用户id不能为空")
    private String clubid;

    /**
     * 职务
     */
    @NotBlank(message = "职务不能为空")
    private String position;

    /**
     * 状态(0:初始;1:审核;2参与)
     */
    @NotNull
    private Integer status;

}