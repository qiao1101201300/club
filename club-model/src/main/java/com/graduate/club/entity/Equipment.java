package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Equipment extends BaseEntity {
    /**
    * 器材名称
    */
    @NotBlank(message = "器材名称不能为空")
    private String name;

    /**
    * 器材数量
    */
    @NotNull(message = "器材数量不能为空")
    private Integer num;

}