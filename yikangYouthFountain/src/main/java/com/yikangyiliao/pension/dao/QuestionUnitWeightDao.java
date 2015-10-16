package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionUnitWeight;

public interface QuestionUnitWeightDao {
    int deleteByPrimaryKey(Long questionUnitWeightId);

    int insert(QuestionUnitWeight record);

    int insertSelective(QuestionUnitWeight record);

    QuestionUnitWeight selectByPrimaryKey(Long questionUnitWeightId);

    int updateByPrimaryKeySelective(QuestionUnitWeight record);

    int updateByPrimaryKey(QuestionUnitWeight record);
}