package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.entity.ServiceItem;
import com.yikangyiliao.pension.manager.ServiceItemManager;

@Service(value="serviceItemService")
public class ServiceItemService {

	@Autowired
	private ServiceItemManager serviceItemManager;
	
	
	
	
	
	public Map<String,Object> selectServiceItemService(Map<String,Object> paramMap){
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(1==1){
			List<ServiceItem> rtnData=serviceItemManager.selectServiceItemsListPage(null);
			rtnMap.put("data", rtnData);
			rtnMap.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}
		
		return rtnMap;
		
	}
	
	public Map<String,Object> selectServiceItemDesc(Map<String,Object> paramMap ){
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(null != paramMap.get("serviceItemId")){
			
			String serviceItemId=paramMap.get("serviceItemId").toString();
		
			Map<String,Object> rtnData=serviceItemManager.selectServiceItemDescByServiceItemId(Long.valueOf(serviceItemId));
			rtnMap.put("data", rtnData);
			rtnMap.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}
		
		return rtnMap;
	}
	
	
}
