package com.graduate.club.api;

import com.graduate.club.entity.Club;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.ClubService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ClubVO;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/club")
@Api(value = "社团信息", tags = "ClubApi")
@Slf4j
public class ClubApi {
    @Autowired
    private ClubService clubService;

    @ApiOperation(value = "查询社团中的用户")
    @RequestMapping(value = "selectClubUser", method = RequestMethod.POST)
    public ResultVO selectClubUserByClubid(@ApiParam(name = "clubid", value = "社团id", required = true) String clubid,
                                           @ApiParam(name = "status", value = "用户在社团中状态", required = true) Integer status) {
        //查询社团用户数量
        PageVO pageVO = clubService.selectClubUserByClubid(clubid, status);
        return ResultUtils.success(pageVO);
    }

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid Club club) {
        boolean b = clubService.insertSelective(club);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Club club) {
        if (StringUtils.isBlank(club.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "部门id不能为空");
        }
        boolean b = clubService.updateByPrimaryKeySelective(club);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody Club club) {
        if (StringUtils.isBlank(club.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "部门id不能为空");
        }
        club.setStatus(Constants.Status.DELECT);
        boolean b = clubService.updateByPrimaryKeySelective(club);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("select")
    public ResultVO select(@RequestBody ClubVO clubVO){
        PageVO pageVO =clubService.selectByMap(clubVO);
        return ResultUtils.success(pageVO);
    }
}
