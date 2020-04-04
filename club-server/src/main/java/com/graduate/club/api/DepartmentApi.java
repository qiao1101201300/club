package com.graduate.club.api;

import com.alibaba.fastjson.JSONObject;
import com.graduate.club.entity.Department;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.DepartmentService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.DepartmentVO;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/department")
@Api(value = "社团部门", tags = "DepartmentApi")
@Slf4j
public class DepartmentApi {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid Department department) {
        department.setStatus(Constants.Status.SUCCESS);
        boolean b = departmentService.insertSelective(department);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Department department) {
        if (StringUtils.isBlank(department.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "部门id不能为空");
        }
        boolean b = departmentService.updateByPrimaryKeySelective(department);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody Department department) {
        if (StringUtils.isBlank(department.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "部门id不能为空");
        }
        department.setStatus(Constants.Status.DELECT);
        boolean b = departmentService.updateByPrimaryKeySelective(department);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("select")
    public ResultVO select(@RequestBody DepartmentVO departmentVO) {
        PageVO pageVO = departmentService.selectByMap(departmentVO);
        return ResultUtils.success(pageVO);
    }
}
