package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionUnitAnswerMap;

public interface QuestionUnitAnswerMapDao {
    int deleteByPrimaryKey(Long questionCrosswisePortraitAnswerId);

    int insert(QuestionUnitAnswerMap record);

    int insertSelective(QuestionUnitAnswerMap record);

    QuestionUnitAnswerMap selectByPrimaryKey(Long questionCrosswisePortraitAnswerId);

    int updateByPrimaryKeySelective(QuestionUnitAnswerMap record);

    int updateByPrimaryKey(QuestionUnitAnswerMap record);
}