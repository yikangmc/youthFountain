package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Location;

public interface LocationDao {
    int deleteByPrimaryKey(Long locationId);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Long locationId);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);
}