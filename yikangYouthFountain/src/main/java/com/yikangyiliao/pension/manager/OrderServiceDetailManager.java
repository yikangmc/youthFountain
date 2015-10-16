package com.yikangyiliao.pension.manager;

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

	
}
