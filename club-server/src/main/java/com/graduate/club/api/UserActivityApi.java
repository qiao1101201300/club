package com.graduate.club.api;

import com.alibaba.fastjson.JSONObject;
import com.graduate.club.entity.UserActivity;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.UserActivityService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ResultVO;
import com.graduate.club.vo.UserActivityVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/review")
@Api(value = "用户评论", tags = "UserActivityApi")
@Slf4j
public class UserActivityApi {
    @Autowired
    private UserActivityService userActivityService;

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid UserActivity userActivity) {
        userActivity.setStatus(Constants.Status.INIT);
        boolean flag = userActivityService.insertSelective(userActivity);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("select")
    public ResultVO select(@RequestBody UserActivityVO userActivityVO){
        PageVO pageVO = userActivityService.selectByMap(userActivityVO);
        return ResultUtils.success(pageVO);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody @Valid UserActivity userActivity) {
        boolean flag = userActivityService.updateByPrimaryKeySelective(userActivity);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
    @PostMapping("delete")
    public ResultVO delete(@RequestBody String param) {
        JSONObject jsonObject = JSONObject.parseObject(param);
        if (StringUtils.isBlank(jsonObject.getString("id"))) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "活动id不能为空");
        }
        UserActivity userActivity = new UserActivity();
        userActivity.setId(jsonObject.getString("id"));
        userActivity.setStatus(Constants.Status.DELECT);
        boolean b = userActivityService.updateByPrimaryKeySelective(userActivity);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
