package com.graduate.club.api;

import com.graduate.club.entity.ClubType;
import com.graduate.club.service.ClubTypeService;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clubType")
@Api(value = "社团类型", tags = "ClubTypeApi")
@Slf4j
public class ClubTypeApi {
    @Autowired
    private ClubTypeService clubTypeService;

    @PostMapping("getAllClubType")
    public ResultVO getAllClubType() {
        List<ClubType> clubTypes = clubTypeService.selectAll();
        return ResultUtils.success(clubTypes);
    }
}
