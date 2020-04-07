package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClubLease extends BaseEntity {
    /**
    * 社团id
    */
    @NotBlank(message = "社团id不能为空")
    private String clubid;

    /**
    * 状态
    */
    private Integer status;

    /**
    * 器材id
    */
    @NotBlank(message = "器材id不能为空")
    private String equipmentid;

    /**
    * 数量
    */
    @NotNull(message = "数量不能为空")
    private Integer num;

}