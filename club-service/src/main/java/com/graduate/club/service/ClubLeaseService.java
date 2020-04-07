package com.graduate.club.service;

import com.graduate.club.entity.ClubLease;
import com.graduate.club.vo.ClubLeaseVO;
import com.graduate.club.vo.PageVO;

public interface ClubLeaseService extends BaseService<ClubLease> {

    boolean create(ClubLease clubLease);

    boolean update(ClubLease clubLease);

    PageVO selectByMap(ClubLeaseVO clubLeaseVO);

    boolean delete(ClubLease clubLease);
}
