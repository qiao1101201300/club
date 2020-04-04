package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Review extends BaseEntity {
    /**
     * 社团id
     */
    @NotNull(message = "社团id不能为空")
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