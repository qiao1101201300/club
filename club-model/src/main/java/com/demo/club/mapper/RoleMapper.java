package com.demo.club.mapper;

import com.demo.club.entity.Role;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {
    Role selectAllMenu(String id);
}