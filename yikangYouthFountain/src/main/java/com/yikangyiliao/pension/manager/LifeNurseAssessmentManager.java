package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionUnitDao;
import com.yikangyiliao.pension.dao.SurveyTableDao;



/**
 * @author liushuaic
 * @date 2015/08/06 14:42
 * 
 * */
@Component
public class LifeNurseAssessmentManager {
	
	@Autowired
	private SurveyTableDao sureyScoreDao;
	
	@Autowired
	private QuestionUnitDao questionUnitDao;
	
	   /**
     * @author liushuaic
     * @date 2015/08/06
     * 查询生活护理评估表的，评估项
     * **/
    public  List<Map<String,Object>> getQuestionCrosswiseByTableName(){
    	return sureyScoreDao.getQuestionCrosswiseByTableName("生活护理评估表");
    }

    
    /**
     * 
     * @author liushuaic
     * @date 2015/08/06
     * 返回所有的答案
     * **/
    public List<Map<String,Object>> getQuestionUnitAnswerMapByQuetionCrosswiseId(Long questionCrosswiseId){
    	return questionUnitDao.getQuestionUnitAnswerMapByQuetionCrosswiseId(questionCrosswiseId);
    }
    
}
