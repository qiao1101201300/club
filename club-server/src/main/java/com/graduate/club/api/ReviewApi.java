package com.graduate.club.api;

import com.alibaba.fastjson.JSONObject;
import com.graduate.club.entity.Club;
import com.graduate.club.entity.Review;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.ClubService;
import com.graduate.club.service.ReviewService;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.RecruitVO;
import com.graduate.club.vo.ResultVO;
import com.graduate.club.vo.ReviewVO;
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
@Api(value = "社团评审", tags = "ReviewApi")
@Slf4j
public class ReviewApi {
    @Autowired
    ReviewService reviewService;
    @Autowired
    ClubService clubService;

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid Review review) {
        review.setStar(0);
        boolean flag = reviewService.insertSelective(review);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("select")
    public ResultVO select(@RequestBody ReviewVO reviewVO) {
        PageVO page = reviewService.selectByMap(reviewVO);
        return ResultUtils.success(page);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Review review){
        if (StringUtils.isBlank(review.getId())){
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(),"评审id不能为空");
        }
        if (review.getStar() != null){
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(),"星级不能为空");
        }
        Club club = clubService.selectByPrimaryKey(review.getClubid());
        club.setStar(review.getStar());
        clubService.updateByPrimaryKey(club);
        boolean flag = reviewService.updateByPrimaryKeySelective(review);
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
    @PostMapping("delete")
    public ResultVO delete(@RequestBody Review review){
        if (StringUtils.isBlank(review.getId())){
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(),"评审id不能为空");
        }
        boolean flag = reviewService.deleteByPrimaryKey(review.getId());
        return flag ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
