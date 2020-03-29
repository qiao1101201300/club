package com.graduate.club.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/club")
@Api(value = "我的社团",tags ="ClubApi" )
@Slf4j
public class ClubApi {
}
