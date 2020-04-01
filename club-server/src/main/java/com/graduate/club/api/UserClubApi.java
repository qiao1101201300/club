package com.graduate.club.api;

import com.graduate.club.entity.Club;
import com.graduate.club.entity.User;
import com.graduate.club.entity.UserClub;
import com.graduate.club.service.ActivityService;
import com.graduate.club.service.ClubService;
import com.graduate.club.service.UserClubService;
import com.graduate.club.vo.ResultVO;
import com.graduate.club.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
@Api(value = "用户社团",tags ="UserClubApi" )
@Slf4j
public class UserClubApi {
    @Autowired
    private UserClubService userClubService;

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ClubService clubService;

    @ApiOperation(value = "查询用户加入的社团")
    @RequestMapping(value = "selectMyClub",method = RequestMethod.POST)
    public ResultVO selectMyClub(@ApiParam(name = "userId",value = "用户id",required = true) String userId ) {
        ResultVO resultVO = userClubService.selectMyClub(userId);
        return resultVO;
    }

}
