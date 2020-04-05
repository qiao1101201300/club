package com.graduate.club.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.graduate.club.dao.UserDao;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.enums.RoleEnum;
import com.graduate.club.exception.ServerException;
import com.graduate.club.service.UserProfileService;
import com.graduate.club.util.*;
import com.graduate.club.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.graduate.club.entity.User;
import com.graduate.club.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {

    @Value("${aes.key}")
    private String aesKey;
    @Autowired
    UserDao userDao;
    @Autowired
    UserProfileService userProfileService;

    @Override
    public User getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    @Override
    public ResultVO login(User user) {
        User user1 = null;
        try {
            user1 = userDao.getUserByUserName(user.getUsername());

            if (user1 == null) {
                return ResultUtils.error(ResultEnum.USER_NOT_FOUND);
            }
            UserProfile userProfile = userProfileService.selectByUserId(user1.getId());
            String password = AesUtils.Decrypt(user1.getPassword(), aesKey);
            password = MD5Utils.md5(password);
            if (!user.getPassword().equals(password)) {
                return ResultUtils.error(ResultEnum.PASSWORD_ERROR);
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", user.getId());
            String token = "Bear " + JwtUtils.genToken(map);
            JSONObject ret = new JSONObject();
            ret.put("token", token);
            ret.put("username", user.getUsername());
            ret.put("level", userProfile.getLevel());
            return ResultUtils.success(ret);
        } catch (Exception e) {
            log.error("[login password decrypt error] password={}", user.getPassword());
            throw new ServerException(ResultEnum.ERROR.getCode(), ErrorUtils.getStackTrace(e));
        }
    }

    @Override
    public ResultVO create(User user) {
        User user1 = userDao.getUserByUserName(user.getUsername());
        if (user1 != null) {
            return ResultUtils.error(ResultEnum.USERNAME_EXISTS);
        }
        try {
            user.setId(UUIDUtils.getUUID());
            user.setPassword(AesUtils.Encrypt(user.getPassword(), aesKey));
            user.setStatus(Constants.UserStatus.NORMAL);
            UserProfile userProfile = new UserProfile();
            userProfile.setUserid(user.getId());
            userProfile.setLevel(Constants.Level.ORDINARYUSERS);
            userProfileService.insertSelective(userProfile);
            boolean b = insertSelective(user);
            return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
        } catch (Exception e) {
            log.error("[create password encrypt error] password={}", user.getPassword());
            throw new ServerException(ResultEnum.ERROR.getCode(), ErrorUtils.getStackTrace(e));
        }
    }
}
