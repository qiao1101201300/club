package com.graduate.club.entity;

import lombok.Data;

@Data
public class Review extends BaseEntity {
    /**
     * 社团id
     */
    private String clubid;

    /**
     * 评审人id
     */
    private String adminid;

    /**
     * 星级
     */
    private Integer star;
}