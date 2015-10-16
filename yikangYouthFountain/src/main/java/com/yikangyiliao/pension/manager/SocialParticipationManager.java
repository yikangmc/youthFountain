package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionSurveyMapDao;
import com.yikangyiliao.pension.dao.SurveyTableDao;


/**
 * @author liushuaic
 * @date 2015/08/12 17:38
 * 社会参与
 * */
@Component
public class SocialParticipationManager {

	@Autowired
	private QuestionSurveyMapDao questionSurveyMapDao;
	
	
	@Autowired
	private SurveyTableDao surveyTableDao;
	
    /**
     * @author liushuaic
     * @date	2015/08/12 11:47
     * @desc 社会参与
     * */
	public Map<String,Object> getQuestionsAndAnswersByTableName(){
	 return  surveyTableDao.getQuestionsAndAnswersByTableName("社会参与评估表");
	}
	
	
	
}
