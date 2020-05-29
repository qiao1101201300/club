package com.demo.club.api;

import com.demo.club.entity.User;
import com.demo.club.enums.ResultEnum;
import com.demo.club.service.UserService;
import com.demo.club.util.*;
import com.demo.club.vo.LoginVO;
import com.demo.club.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/user")
public class UserApi {
    @Value("${aes.key}")
    private String aesKey;
    @Autowired
    private UserService userService;


    @ApiOperation(value = "登陆", notes = "参数:用户名 密码 盐")
    @PostMapping("login")
    public ResultVO login(@RequestBody @Valid LoginVO loginVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        String password = loginVO.getPassword();
        String token = "";
        //用户信息
        User user = new User();
        user.setUsername(loginVO.getUsername());
        try {
            password = MD5Utils.hmacMd5(password, loginVO.getSalt());
            password = AesUtils.Encrypt(password, aesKey);
        } catch (Exception e) {
            log.error("[Login Error] e={}", ErrorUtils.getStackTrace(e));
            return ResultUtils.error(ResultEnum.ERROR.getCode(), "登陆失败！");
        }
        user = userService.selectOne(user);
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(password)) {
            return ResultUtils.error(ResultEnum.ERROR.getCode(), "登陆失败！");
        } else {
            //生成token
            Map<String, Object> m = new HashMap<>();
            Date expiresAt = DateUtils.addDays(new Date(), 1);
            m.put("userid", user.getId());
            m.put("expiresAt", expiresAt);
            token = JwtUtils.genToken(m);
            String redisToken = (String) RedisUtils.get(user.getId());
            if (StringUtils.isNotBlank(redisToken)) {
                token = redisToken;
            } else {
                RedisUtils.set(user.getId(), token, expiresAt.getTime());

            }
            token = "Bear " + token;
        }
        return ResultUtils.success(token);
    }

    @PostMapping("logout")
    public ResultVO logout(@RequestHeader("token") String token) {
        Map<String, Object> result = new HashMap<>();
        userService.logout(token);
        return ResultUtils.success();
    }

    @RequiresPermissions({"select"})
    @PostMapping("selectAll")
    public ResultVO selectAll() {
        List<User> users = userService.selectAll();
        return ResultUtils.success(users);
    }
}
