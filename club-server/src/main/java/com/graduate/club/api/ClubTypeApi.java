package com.graduate.club.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clubType")
@Api(value = "社团类型",tags ="ClubTypeApi" )
@Slf4j
public class ClubTypeApi {
}
