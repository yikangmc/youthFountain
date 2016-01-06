package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.OrderServiceDetailDao;
import com.yikangyiliao.pension.entity.OrderServiceDetail;



@Component
public class OrderServiceDetailManager {
	
	
	@Autowired
	private OrderServiceDetailDao orderServiceDetailDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/10 14:28
	 * 获取某一个定单的评估人员
	 * ***/
	public OrderServiceDetail getEstimateOrderServiceDetailByOrderId(Long orderId){
		return	orderServiceDetailDao.getEstimateOrderServiceDetailByOrderId(orderId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/10 16:55
	 * 修改orderDetail 信息
	 * */
	public int updateOrderServiceDetailSelective(OrderServiceDetail orderServiceDetail){
		
		return orderServiceDetailDao.updateByPrimaryKeySelective(orderServiceDetail);
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/12 14:53
	 * 添加定单详情
	 * 
	 * **/
	public int insertSelective(OrderServiceDetail record){
		return orderServiceDetailDao.insertSelective(record);
	}

	
	/**
	 * @author liushuaic
	 * @date 2016/1/5 19:04
	 * @desc 获取某一个服务订单的信息 ，根据，  orderId and serviceItemIds
	 * */
	public Map<String,Object> getServiceDetailByOrderIdAndServiceItemId(Long serviceItemId,Long orderId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("orderId",orderId);
		paramData.put("serviceItemId", serviceItemId);
		return orderServiceDetailDao.getServiceDetailByOrderIdAndServiceItemId(paramData);
	}
	
	
}
