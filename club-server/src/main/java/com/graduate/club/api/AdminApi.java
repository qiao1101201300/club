package com.graduate.club.api;

import com.graduate.club.entity.Admin;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.AdminService;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin")
@Api(value = "管理员", tags = "AdminApi")
@Slf4j
public class AdminApi {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "login")
    public ResultVO login(@ApiParam(value = "Admin") @RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid Admin admin) {
        if (StringUtils.isBlank(admin.getName())) {
            return ResultUtils.error(ResultEnum.USERNAME_EXISTS);
        }
        return adminService.create(admin);
    }

}
