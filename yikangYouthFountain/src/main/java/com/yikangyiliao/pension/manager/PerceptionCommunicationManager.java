package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionSurveyMapDao;
import com.yikangyiliao.pension.dao.SurveyTableDao;


/**
 * @author liushuaic
 * @date 2015/08/12 17:38
 * 感知与沟通
 * */
@Component
public class PerceptionCommunicationManager {

	@Autowired
	private QuestionSurveyMapDao questionSurveyMapDao;
	
	
	@Autowired
	private SurveyTableDao surveyTableDao;
	
    /**
     * @author liushuaic
     * @date	2015/08/12 11:47
     * @desc 长谷川痴呆量表，查询出所有的问题及答案
     * */
	public Map<String,Object> getQuestionsAndAnswersByTableName(){
	 return  surveyTableDao.getQuestionsAndAnswersByTableName("感知觉与沟通评估表");
	}
	
	
	
}
