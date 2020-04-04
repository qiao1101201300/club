package com.graduate.club.api;

import com.alibaba.fastjson.JSONObject;
import com.graduate.club.entity.Activity;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.ActivityService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ActivityVO;
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
@RequestMapping("/api/activity")
@Api(value = "社团活动", tags = "ActivityApi")
@Slf4j
public class ActivityApi {
    @Autowired
    private ActivityService activityService;

    @PostMapping("selectActivity")
    public ResultVO selectActivity(@RequestBody(required = false) @Valid ActivityVO activityVO) {
        PageVO pageVO = activityService.selectActivity(activityVO);
        return ResultUtils.success(pageVO);
    }

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid Activity activity) {
        boolean b = activityService.create(activity);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Activity activity) {
        if (StringUtils.isBlank(activity.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "活动id不能为空");
        }
        boolean b = activityService.updateByPrimaryKey(activity);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody Activity activity) {
        if (StringUtils.isBlank(activity.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "活动id不能为空");
        }
        activity.setStatus(Constants.Status.DELECT);
        boolean b = activityService.updateByPrimaryKeySelective(activity);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
