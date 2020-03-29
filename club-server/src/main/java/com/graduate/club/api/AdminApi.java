package com.graduate.club.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@Api(value = "管理员",tags ="AdminApi" )
@Slf4j
public class AdminApi {
}
