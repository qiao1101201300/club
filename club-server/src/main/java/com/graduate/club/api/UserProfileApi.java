package com.graduate.club.api;

import com.graduate.club.entity.UserProfile;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.UserProfileService;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userprofile")
@Api(value = "用户个人信息", tags = "UserProfileApi")
@Slf4j
public class UserProfileApi {
    @Autowired
    private UserProfileService userProfileService;

    @ApiOperation(value = "查询社团中的某个用户信息")
    @RequestMapping(value = "selectClubUserByUserId", method = RequestMethod.POST)
    public ResultVO selectClubUserByUserId(@ApiParam(name = "userid", value = "社团成员id", required = true) String userid) {
        //查询社团用户信息
        UserProfile resultVO = userProfileService.selectByUserId(userid);
        return ResultUtils.success(resultVO);
    }

    @PostMapping("create")
    public ResultVO create(UserProfile userProfile) {
        boolean b = userProfileService.insert(userProfile);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
    @PostMapping("update")
    public ResultVO update(UserProfile userProfile){
        boolean b = userProfileService.updateByUserId(userProfile);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
