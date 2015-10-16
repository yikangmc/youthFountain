package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.PerceptionCommunicationManager;




/**
 * 
 * @author liushuaic
 * 感知与沟通
 * 
 * */
@Service(value="pserceptionCommunicationsService")
public class PerceptionCommunicationsService {

	
	@Autowired
	private PerceptionCommunicationManager perceptionCommunicationManager;
	
	
	public Map<String,Object> getTable(Map<String,Object> paramData){
		Map<String,Object> rtnMap=new HashMap<String, Object>();
		
		Map<String,Object> data=perceptionCommunicationManager.getQuestionsAndAnswersByTableName();

		rtnMap.put("data", data);
		rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		
		return rtnMap;
		
	}
	
}
