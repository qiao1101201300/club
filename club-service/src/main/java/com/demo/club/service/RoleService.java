package com.demo.club.service;

import com.demo.club.entity.Role;

public interface RoleService extends BaseService<Role> {


    Role selectAllMenu(String level);
}
