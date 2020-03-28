package com.graduate.club.entity;

import lombok.Data;

@Data
public class ClubType extends BaseEntity {
    /**
     * 班级名称
     */
    private String name;

    /**
     * 班级code
     */
    private String code;

}