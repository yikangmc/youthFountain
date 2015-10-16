package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.LifeNurseAssessmentManager;

/**
 * @author liushuaic
 * @date 2015/08/06 14:37
 * @desc 生活护理评估
 * 
 * 
 * ***/

@Service(value="lifeNurseAssessmentService")
public class LifeNurseAssessmentService {

	
	private Logger logger =Logger.getLogger(LifeNurseAssessmentService.class);
	
	@Autowired
	private LifeNurseAssessmentManager lifeNurseAssessmentManager;

	/**
	 * @author liushuaic
	 * @date 2015/08/06 查询生活护理评估表的，评估项
	 * **/
	public Map<String, Object> getQuestionCrosswiseByTableName(Map<String,Object> paramData) {
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
		   	
			 List<Map<String,Object>> data=lifeNurseAssessmentManager.getQuestionCrosswiseByTableName();
			rtnData.put("data", data);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/06 
	 * 查询某一个调查项
	 * **/
	public Map<String, Object> getQuestionUnitAnswerMapByQuetionCrosswiseId(Map<String,Object> paramData) {
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
		   	if(paramData.containsKey("questionCrosswiseId")){
		   		String questionCrosswiseId=paramData.get("questionCrosswiseId").toString();
		   		
		   		List<Map<String,Object>> data=lifeNurseAssessmentManager.getQuestionUnitAnswerMapByQuetionCrosswiseId(Long.valueOf(questionCrosswiseId));
				rtnData.put("data", data);
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		   	}
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
		
	}

}
