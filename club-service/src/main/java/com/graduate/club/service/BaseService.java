package com.graduate.club.service;

import com.github.pagehelper.PageInfo;
import com.graduate.club.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    /**
     * 动态插入
     *
     * @param info
     * @return
     */
    boolean insertSelective(T info);

    /**
     * 添加实体
     *
     * @param info
     * @return
     */
    boolean insert(T info);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(String id);


    /**
     * 根据主键更新
     *
     * @param info
     * @return
     */
    boolean updateByPrimaryKey(T info);

    /**
     * 根据主键动态更新
     *
     * @param info
     * @return
     */
    boolean updateByPrimaryKeySelective(T info);

    /**
     * 根据主键动态更新普通实体和文件
     *
     * @param info
     * @return
     */
    //boolean updateByPrimaryKeyWithBLOBs(T info) ;

    /**
     * 分页查询
     *
     * @return
     */
    PageInfo<T> selectList(int pageNum, int pageSize);

    /**
     * 根据主键查询
     *
     * @return
     */
    T selectByPrimaryKey(String id);

    /**
     * 查询所有
     *
     */

    List<T> selectAll();

}
