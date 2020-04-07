package com.graduate.club.api;

import com.graduate.club.entity.ClubLease;
import com.graduate.club.entity.Equipment;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.ClubLeaseService;
import com.graduate.club.service.EquipmentService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ClubLeaseVO;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clubLease")
@Api(value = "租赁信息", tags = "ClubLeaseApi")
@Slf4j
public class ClubLeaseApi {
    @Autowired
    private ClubLeaseService clubLeaseService;

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid ClubLease clubLease) {
        clubLease.setStatus(Constants.Status.INIT);
        boolean b = clubLeaseService.create(clubLease);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody @Valid ClubLease clubLease) {
        if (StringUtils.isBlank(clubLease.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "租赁id不能为空");
        }
        boolean b = clubLeaseService.update(clubLease);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("select")
    public ResultVO select(@RequestBody @Valid ClubLeaseVO clubLeaseVO) {
        PageVO pageVO = clubLeaseService.selectByMap(clubLeaseVO);
        return ResultUtils.success(pageVO);
    }
    @PostMapping("delete")
    public ResultVO delete(@RequestBody ClubLease clubLease) {
        if (StringUtils.isBlank(clubLease.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "器材id不能为空");
        }
        boolean b = clubLeaseService.delete(clubLease);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
