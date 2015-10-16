package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionUnitDao;
import com.yikangyiliao.pension.dao.SurveyTableDao;

@Component
public class OldManTumbleManager {

	@Autowired
	private SurveyTableDao sureyScoreDao;

	@Autowired
	private QuestionUnitDao questionUnitDao;

	/**
	 * @author liushuaic
	 * @date 2015/08/07 15:16
	 * 
	 * **/
	public Map<String,Object> getQuestionCrosswiseByTableNameTwo() {
		return sureyScoreDao.getQuestionCrosswiseByTableNameTwo("老人跌倒风险评估");
	}

}
