package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ServiceNote;

public interface ServiceNoteDao {
    int deleteByPrimaryKey(Long serviceNoteId);

    int insert(ServiceNote record);

    int insertSelective(ServiceNote record);

    ServiceNote selectByPrimaryKey(Long serviceNoteId);

    int updateByPrimaryKeySelective(ServiceNote record);

    int updateByPrimaryKey(ServiceNote record);
}