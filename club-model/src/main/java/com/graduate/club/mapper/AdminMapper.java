package com.graduate.club.mapper;

import com.graduate.club.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends BaseMapper<Admin> {

    Admin getUserByUserName(@Param("username") String username, @Param("status") int status);
}