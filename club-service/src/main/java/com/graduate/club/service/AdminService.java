package com.graduate.club.service;

import com.graduate.club.entity.Admin;
import com.graduate.club.vo.ResultVO;

public interface AdminService extends BaseService<Admin> {

    ResultVO login(Admin admin);

    ResultVO create(Admin admin);
}
