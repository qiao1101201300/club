package com.graduate.club.api;

import com.alibaba.fastjson.JSONObject;
import com.graduate.club.entity.Recruit;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.RecruitService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.RecruitVO;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recruit")
@Api(value = "社团招聘", tags = "RecruitApi")
@Slf4j
public class RecruitApi {
    @Autowired
    private RecruitService recruitService;

    @PostMapping("create")
    public ResultVO create(@RequestBody Recruit recruit) {
        recruit.setStatus(Constants.Status.INIT);
        boolean flag = recruitService.insertSelective(recruit);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Recruit recruit) {
        if (StringUtils.isBlank(recruit.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "招聘id不能为空");
        }
        boolean flag = recruitService.updateByPrimaryKey(recruit);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("select")
    public ResultVO select(@RequestBody RecruitVO recruitVO) {
        PageVO page = recruitService.selectByMap(recruitVO);
        return ResultUtils.success(page);
    }
    @PostMapping("delete")
    public ResultVO delete(@RequestBody String param){
        JSONObject jsonObject = JSONObject.parseObject(param);
        if (StringUtils.isBlank(jsonObject.getString("id"))) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "招聘id不能为空");
        }
        Recruit recruit = new Recruit();
        recruit.setId(jsonObject.getString("id"));
        recruit.setStatus(Constants.Status.DELECT);
        boolean flag = recruitService.updateByPrimaryKey(recruit);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
