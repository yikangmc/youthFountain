package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.OldManTumbleManager;


/**
 * 
 * @author liushuaic
 * @date 2015/08/12 17:09 
 * 老年人跌倒风险评估
 * 
 * **/
@Service(value = "oldManTumbleService")
public class OldManTumbleService {

	
	private Logger logger =Logger.getLogger(LifeNurseAssessmentService.class);
	
	
	@Autowired
	private OldManTumbleManager oldManTumbleManager;
	
	
	
	public Map<String, Object> getTable(Map<String, Object> paramData) {
		Map<String, Object> rtnData = new HashMap<String, Object>();
		try {
			
			Map<String,Object> data=oldManTumbleManager.getQuestionCrosswiseByTableNameTwo();
			System.out.println(new ObjectMapper().writeValueAsString(data));
			rtnData.put("data", data);
			rtnData.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);

		} catch (Exception e) {
			rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message",ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}

}
