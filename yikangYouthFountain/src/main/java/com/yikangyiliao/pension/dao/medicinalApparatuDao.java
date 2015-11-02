package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.MedicinalApparatu;

public interface medicinalApparatuDao {
    int deleteByPrimaryKey(Long medicinalApparatuId);

    int insert(MedicinalApparatu record);

    int insertSelective(MedicinalApparatu record);

    MedicinalApparatu selectByPrimaryKey(Long medicinalApparatuId);

    int updateByPrimaryKeySelective(MedicinalApparatu record);

    int updateByPrimaryKey(MedicinalApparatu record);
}