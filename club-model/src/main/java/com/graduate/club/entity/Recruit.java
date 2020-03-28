package com.graduate.club.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Recruit extends BaseEntity {

    /**
     * 社团id
     */
    private String clubid;

    /**
     * 人数
     */
    private Integer num;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 开始时间
     */
    private Date openDate;

    /**
     * 结束时间
     */
    private Date closeDate;

}