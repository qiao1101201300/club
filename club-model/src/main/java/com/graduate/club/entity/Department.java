package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Department extends BaseEntity {

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    private String name;

    /**
     * 社团id
     */
    @NotBlank(message = "社团id不能为空")
    private String clubid;

    /**
     * 负责人id
     */
    @NotBlank(message = "负责人id不能为空")
    private String userid;

    /**
     * 状态
     */
    private Integer status;

}