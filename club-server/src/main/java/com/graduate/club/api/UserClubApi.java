package com.graduate.club.api;

import com.graduate.club.entity.UserClub;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.UserClubService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/userClub")
@Api(value = "用户社团", tags = "UserClubApi")
@Slf4j
public class UserClubApi {
    @Autowired
    private UserClubService userClubService;

    @ApiOperation(value = "查询用户加入的社团")
    @RequestMapping(value = "selectMyClub", method = RequestMethod.POST)
    public ResultVO selectMyClub(@ApiParam(name = "userId", value = "用户id", required = true) String userId) {
        //查询用户加入的社团数
        ResultVO resultVO = userClubService.selectMyClub(userId);
        return ResultUtils.success(resultVO);
    }

    @ApiOperation(value = "模糊查询用户")
    @RequestMapping(value = "selectClubUser", method = RequestMethod.POST)
    public ResultVO selectClubUser(@ApiParam(name = "userClub", value = "按条件查询用户", required = true) UserProfile userProfile) {
        ResultVO resultVO = userClubService.selectClubUser(userProfile);
        return ResultUtils.success(resultVO);
    }

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid UserClub userClub) {
        userClub.setStatus(Constants.Status.INIT);
        boolean b = userClubService.insertSelective(userClub);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody UserClub userClub) {
        if (StringUtils.isBlank(userClub.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "评审id不能为空");
        }
        boolean flag = userClubService.updateByPrimaryKeySelective(userClub);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody UserClub userClub) {
        if (StringUtils.isBlank(userClub.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "评审id不能为空");
        }
        userClub.setStatus(Constants.Status.DELECT);
        boolean flag = userClubService.updateByPrimaryKeySelective(userClub);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
