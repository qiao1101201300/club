package com.graduate.club.service.impl;

import com.graduate.club.dao.UserClubDao;
import com.graduate.club.entity.User;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.exception.ServerException;
import com.graduate.club.service.BaseService;
import com.graduate.club.util.ErrorUtils;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.graduate.club.entity.UserClub;
import com.graduate.club.mapper.UserClubMapper;
import com.graduate.club.service.UserClubService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserClubServiceImpl extends BaseServiceImpl<UserClub, UserClubDao> implements UserClubService {

    @Autowired
    private UserClubMapper userClubMapper;
    @Autowired
    private UserClubService userClubService;
    @Override
    public ResultVO selectMyClub(String userId) {
        if (null == userId){
            return ResultUtils.error(ResultEnum.ERROR);
        }
        try {
            List<UserClub> lists=new ArrayList<>();
            lists = (List<UserClub>) userClubMapper.selectByPrimaryKey(userId);
            return ResultUtils.success(lists);
        }catch (Exception e){
            throw new ServerException(ResultEnum.ERROR.getCode(), ErrorUtils.getStackTrace(e));
        }

    }
}
