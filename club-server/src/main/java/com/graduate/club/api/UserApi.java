package com.graduate.club.api;

import com.graduate.club.entity.User;
import com.graduate.club.service.UserService;
import com.graduate.club.vo.ResultVO;
import com.graduate.club.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResultVO login(@RequestBody @Valid UserVO userVO) {
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
}
