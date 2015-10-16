package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionAnswerMap;

public interface QuestionAnswerMapDao {
    int deleteByPrimaryKey(Long questionAnswerId);

    int insert(QuestionAnswerMap record);

    int insertSelective(QuestionAnswerMap record);

    QuestionAnswerMap selectByPrimaryKey(Long questionAnswerId);

    int updateByPrimaryKeySelective(QuestionAnswerMap record);

    int updateByPrimaryKey(QuestionAnswerMap record);
}