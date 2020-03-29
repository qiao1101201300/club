package com.graduate.club.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
@Api(value = "用户个人信息",tags ="UserProfileApi" )
@Slf4j
public class UserProfileApi {
}
