package com.graduate.club.service;

import com.graduate.club.entity.Recruit;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.RecruitVO;

public interface RecruitService extends BaseService<Recruit>{

    PageVO selectByMap(RecruitVO recruitVO);

    Recruit selectByClubId(String clubid);
}
