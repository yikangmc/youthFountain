package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionCrosswise;

public interface QuestionCrosswiseDao {
    int deleteByPrimaryKey(Long questionCrosswiseId);

    int insert(QuestionCrosswise record);

    int insertSelective(QuestionCrosswise record);

    QuestionCrosswise selectByPrimaryKey(Long questionCrosswiseId);

    int updateByPrimaryKeySelective(QuestionCrosswise record);

    int updateByPrimaryKey(QuestionCrosswise record);
}