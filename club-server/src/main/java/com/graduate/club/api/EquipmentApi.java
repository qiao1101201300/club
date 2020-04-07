package com.graduate.club.api;

import com.graduate.club.entity.Equipment;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.EquipmentService;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.EquipmentVO;
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
@RequestMapping("/api/equipment")
@Api(value = "器材信息", tags = "EquipmentApi")
@Slf4j
public class EquipmentApi {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid Equipment equipment) {
        boolean b = equipmentService.insertSelective(equipment);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Equipment equipment) {
        if (StringUtils.isBlank(equipment.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "器材id不能为空");
        }
        boolean b = equipmentService.updateByPrimaryKeySelective(equipment);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("select")
    public ResultVO select(@RequestBody EquipmentVO equipmentVO) {
        PageVO pageVO = equipmentService.selectByMap(equipmentVO);
        return ResultUtils.success(pageVO);
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody Equipment equipment) {
        if (StringUtils.isBlank(equipment.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "器材id不能为空");
        }
        boolean b = equipmentService.deleteByPrimaryKey(equipment.getId());
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
