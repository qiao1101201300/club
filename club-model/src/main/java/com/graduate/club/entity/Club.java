package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Club extends BaseEntity {
    /**
     * 创始人id
     */
    @NotBlank(message = "创始人id不能为空")
    private String userid;

    /**
     * 社团负责人
     */
    @NotBlank(message = "社团负责人不能为空")
    private String principalid;

    /**
     * 审批人（admin id）
     */
    @NotBlank(message = "审批人不能为空")
    private String adminid;

    /**
     * 社团名称
     */
    @NotBlank(message = "社团名称不能为空")
    private String name;

    /**
     * 社团状态(0:初始;1:审核;2:删除)
     */
    private Integer status;

    /**
     * 社团类型code
     */
    @NotNull(message = "社团名称不能为空")
    private Integer type;

    /**
     * 社团星级
     */
    private Integer star;

    /**
     * 社团标志
     */
    private String sign;

    /**
     * 社团规模(社团当前人数)
     */
    private Integer scaleNum;

    /**
     * 成立原因
     */
    private String reason;

}