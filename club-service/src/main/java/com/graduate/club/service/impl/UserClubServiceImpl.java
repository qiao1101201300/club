package com.graduate.club.service.impl;

import com.graduate.club.dao.UserClubDao;
import com.graduate.club.dao.UserProfileDao;
import com.graduate.club.dao.impl.UserProfileDaoImpl;
import com.graduate.club.entity.*;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.exception.ServerException;
import com.graduate.club.service.ActivityService;
import com.graduate.club.service.BaseService;
import com.graduate.club.service.ClubService;
import com.graduate.club.util.ErrorUtils;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.vo.MyClubVO;
import com.graduate.club.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ClubService clubService;
    @Autowired
    private UserClubDao userClubDaoImpl;

    /**
     * 根据用户查询所有的社团
     * @param userId
     * @return
     */
    @Override
    public ResultVO selectMyClub(String userId) {
        if (null == userId){
            return ResultUtils.error(ResultEnum.ERROR);
        }
        try {
            //根据用户查询社团
            List<UserClub> lists = (List<UserClub>) userClubMapper.selectByPrimaryKey(userId);
            List myClubVOs = null;
            for (UserClub list : lists) {
                //查询该社团的活动数
                int sum = activityService.sumActivity(list.getClubid());
                MyClubVO myClubVO = new MyClubVO();
                myClubVO.setSumActive(sum);
                //查询该社团的相信信息
                Club club = clubService.selectClubByUserId(list.getUserid());
                BeanUtils.copyProperties(myClubVO, club);
                myClubVOs.add(myClubVO);
            }
            return ResultUtils.success(myClubVOs);
        }catch (Exception e){
            throw new ServerException(ResultEnum.ERROR.getCode(), ErrorUtils.getStackTrace(e));
        }

    }

    @Override
    public ResultVO selectClubUser(UserProfile userProfile) {
        return userClubDaoImpl.selectClubUser(userProfile);
    }

}
