package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ServiceItemDao;
import com.yikangyiliao.pension.entity.ServiceItem;

@Component
public class ServiceItemManager {
	
	
	@Autowired
	private ServiceItemDao serviceItemDao;
	
	
	
    /**
     * @author liushuaic
     * @date 2015/10/27  14:25
     * 查询服务项目列表
     * */
	public List<ServiceItem> selectServiceItemsListPage(Map<String,Object> param){
		return serviceItemDao.selectServiceItemsListPage(param);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/28 11:11
	 * 查询某项目服务详情
	 * **/
	public Map<String,Object> selectServiceItemDescByServiceItemId(Long serviceItemId){
		return serviceItemDao.selectServiceItemDescByServiceItemId(serviceItemId);
	}

}
