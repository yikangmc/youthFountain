package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.QuestionUnit;

public interface QuestionUnitDao {
    int deleteByPrimaryKey(Long questionPortraitId);

    int insert(QuestionUnit record);

    int insertSelective(QuestionUnit record);

    QuestionUnit selectByPrimaryKey(Long questionPortraitId);

    int updateByPrimaryKeySelective(QuestionUnit record);

    int updateByPrimaryKey(QuestionUnit record);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/06
     * @desc 查询一列问题下的，答案
     * ***/
    List<Map<String,Object>> getQuestionUnitAnswerMapByQuetionCrosswiseId(Long questionCrosswiseId);
    
}