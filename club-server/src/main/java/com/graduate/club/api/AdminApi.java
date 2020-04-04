package com.graduate.club.api;

import com.github.pagehelper.PageInfo;
import com.graduate.club.entity.Admin;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.AdminService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ResultVO;
import com.graduate.club.vo.UserVO;
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

        return adminService.create(admin);
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody Admin admin) {
        if (StringUtils.isBlank(admin.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(),"管理员id不能为空");
        }
        admin.setStatus(Constants.UserStatus.FORBID);
        boolean b = adminService.updateByPrimaryKey(admin);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
    @PostMapping("update")
    public ResultVO update(@RequestBody Admin admin) {
        if (StringUtils.isBlank(admin.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(),"管理员id不能为空");
        }
        boolean b = adminService.updateByPrimaryKey(admin);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
    @PostMapping("selectAll")
    public ResultVO select(@RequestBody UserVO userVO){
        PageInfo<Admin> adminPageInfo = adminService.selectList(userVO.getPageNum(), userVO.getPageSize());
        return ResultUtils.success(adminPageInfo);
    }
}
