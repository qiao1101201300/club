package com.graduate.club.entity;

import lombok.Data;

@Data
public class Club extends BaseEntity {

    /**
     * 创始人id
     */
    private String userid;

    /**
     * 审批人（admin id）
     */
    private String adminid;

    /**
     * 社团名称
     */
    private String name;

    /**
     * 社团状态(0:初始;1:审核;2:删除)
     */
    private Integer status;

    /**
     * 社团类型code
     */
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
     * 社团规模
     */
    private Integer scaleNum;

    /**
     * 成立原因
     */
    private String reason;

}