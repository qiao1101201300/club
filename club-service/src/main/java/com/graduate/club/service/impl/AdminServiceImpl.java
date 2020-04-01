package com.graduate.club.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.graduate.club.dao.AdminDao;
import com.graduate.club.entity.Admin;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.exception.ServerException;
import com.graduate.club.service.AdminService;
import com.graduate.club.util.*;
import com.graduate.club.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminDao> implements AdminService {

    @Value("${aes.key}")
    private String aesKey;
    @Autowired
    private AdminDao adminDao;

    @Override
    public ResultVO login(Admin admin) {
        Admin admin1 = null;
        try {
            admin1 = adminDao.getUserByUserName(admin.getUsername());

            if (admin1 == null) {
                return ResultUtils.error(ResultEnum.USER_NOT_FOUND);
            }
            String password = AesUtils.Decrypt(admin1.getPassword(), aesKey);
            password = MD5Utils.md5(password);
            if (!admin.getPassword().equals(password)) {
                return ResultUtils.error(ResultEnum.PASSWORD_ERROR);
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", admin.getId());
            String token = "Bear " + JwtUtils.genToken(map);
            JSONObject ret = new JSONObject();
            ret.put("token", token);
            ret.put("name", admin.getName());
            return ResultUtils.success(ret);
        } catch (Exception e) {
            log.error("[login password decrypt error] password={}", admin.getPassword());
            throw new ServerException(ResultEnum.ERROR.getCode(), ErrorUtils.getStackTrace(e));
        }
    }

    @Override
    public ResultVO create(Admin admin) {
        Admin admin1 = adminDao.getUserByUserName(admin.getUsername());
        if (admin1 != null) {
            return ResultUtils.error(ResultEnum.USERNAME_EXISTS);
        }
        try {
            admin.setPassword(AesUtils.Encrypt(admin.getPassword(), aesKey));
            admin.setStatus(Constants.UserStatus.NORMAL);
            boolean b = insertSelective(admin);
            return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
        } catch (Exception e) {
            log.error("[create password encrypt error] password={}", admin.getPassword());
            throw new ServerException(ResultEnum.ERROR.getCode(), ErrorUtils.getStackTrace(e));
        }
    }
}
