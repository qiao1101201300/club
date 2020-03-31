package com.graduate.club.entity;

import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Activity extends BaseEntity {

    /**
     * 活动名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 活动状态
     */
    private Integer status;

    /**
     * 社团id
     */
    private String clubid;

    /**
     * 活动简介
     */
    private String introduction;

    /**
     * 发起人名称
     */
    @NotBlank(message = "发起人不能为空")
    private String userid;

    /**
     * 活动图片
     */
    private String img;

    /**
     * 参与人数
     */
    private Integer scaleNum;

    /**
     * 实际人数
     */
    private Integer actualNum;

    /**
     * 开始时间
     */
    @NotBlank(message = "开始时间不能为空")
    private Date openDate;

    /**
     * 结束时间
     */
    @NotBlank(message = "结束时间不能为空")
    private Date closeDate;

    /**
     * 审批人（admin id）
     */
    private String approver;
}