package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionSurveyMap;

public interface QuestionSurveyMapDao {
    int deleteByPrimaryKey(Long questionSurveyId);

    int insert(QuestionSurveyMap record);

    int insertSelective(QuestionSurveyMap record);

    QuestionSurveyMap selectByPrimaryKey(Long questionSurveyId);

    int updateByPrimaryKeySelective(QuestionSurveyMap record);

    int updateByPrimaryKey(QuestionSurveyMap record);
}