package com.graduate.club.api;

import com.graduate.club.entity.User;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.UserService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ResultVO;
import com.graduate.club.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Api(value = "用户管理", tags = "UserApi")
@Slf4j
public class UserApi {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登陆")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultVO login(@ApiParam(value = "UserVO") @RequestBody @Valid UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        return userService.login(user);
    }

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        return userService.create(user);
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody User user) {
        if (StringUtils.isBlank(user.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "评审id不能为空");
        }
        user.setStatus(Constants.UserStatus.FORBID);
        boolean b = userService.updateByPrimaryKey(user);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }
}
