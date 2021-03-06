package com.graduate.club.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserVO {
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 用户状态
     */

    private Integer status;

    private int pageSize = 10;
    private int pageNum = 1;
}
