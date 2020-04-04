package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Recruit extends BaseEntity {

    /**
     * 社团id
     */
    @NotBlank(message = "社团id不能为空")
    private String clubid;

    /**
     * 人数
     */
    @NotNull(message = "招聘人数不能为空")
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