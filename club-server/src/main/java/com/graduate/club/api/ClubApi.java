package com.graduate.club.api;

import com.graduate.club.entity.Activity;
import com.graduate.club.entity.Club;
import com.graduate.club.exception.ServerException;
import com.graduate.club.service.ActivityService;
import com.graduate.club.service.ClubService;
import com.graduate.club.service.UserService;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.vo.MyClubVO;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ResultVO;
import com.graduate.club.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/club")
@Api(value = "社团信息",tags ="ClubApi" )
@Slf4j
public class ClubApi {
    @Autowired
    private ClubService clubService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "查询社团中的用户")
    @RequestMapping(value = "selectClubUser",method = RequestMethod.POST)
    public ResultVO selectClubUserByClubid(@ApiParam(name = "clubid",value = "社团id",required = true) String  clubid,
                                           @ApiParam(name = "status",value = "用户在社团中状态",required = true)  Integer status){
        //查询社团用户数量
        PageVO pageVO = clubService.selectClubUserByClubid(clubid, status);
        return ResultUtils.success(pageVO);
    }
}
