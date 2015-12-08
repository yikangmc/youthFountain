package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AppointmentOrderDao;
import com.yikangyiliao.pension.entity.AppointmentOrder;

@Component
public class AppointmentOrderManager {
	
	@Autowired
	private AppointmentOrderDao appointmentOrderDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 14:55
	 * 添加订单
	 * 
	 * */
	public int insertSelective(AppointmentOrder record){
		return appointmentOrderDao.insertSelective(record);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 15:04
	 * 修改定单状态为：进行中
	 * **/
	public int updateAppointmentOrderStatusIsWorking(Long appointmentOrderId){

		Map<String,Object> param=new HashMap<String, Object>();
		param.put("orderStatus", 1);
		param.put("appointmentOrderId", appointmentOrderId);
		return appointmentOrderDao.updateAppointmentOrderStatus(param);
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 15:04
	 * 修改定单状态为：已完成
	 * **/
	public int updateAppointmentOrderStatusIsFinish(Long appointmentOrderId){

		Map<String,Object> param=new HashMap<String, Object>();
		param.put("orderStatus", 2);
		param.put("appointmentOrderId", appointmentOrderId);
		return appointmentOrderDao.updateAppointmentOrderStatus(param);
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 15:55
	 * 修改定单状态为：已评价
	 * 
	 * */
	public int updateAppointmentOrderStatusIsEvaluated(Long appointmentOrderId){
		Map<String,Object> param=new HashMap<String, Object>();
		param.put("orderStatus", 3);
		param.put("appointmentOrderId", appointmentOrderId);
		return appointmentOrderDao.updateAppointmentOrderStatus(param);
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/09 18:22
	 * @desc 查询用户信息根据 预约单号
	 * */
	public Map<String,Object> getUserServiceInfoByOrderId(Long orderId){
		return appointmentOrderDao.getUserServiceInfoByOrderId(orderId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/10 14:13
	 * 获取某一个定单的信息
	 * */
	public AppointmentOrder getAppointmentOrderByOrderId(Long appointmentOrderId){
		return appointmentOrderDao.selectByPrimaryKey(appointmentOrderId);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/30 16:58
	 * @desc 获取我的定单
	 * */
	public List<AppointmentOrder> getAppointmentOrderByUserId(Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("userId", userId);
		return appointmentOrderDao.getMyAppointmentOrderByUserIdOrderStatus(paramData);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/30 16:57
	 * 获取我的未付款的订单
	 * */
	public List<AppointmentOrder> getAppointmentOrderUnPay(Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("userId", userId);
		paramData.put("orderStatus",0);
		return appointmentOrderDao.getMyAppointmentOrderByUserIdOrderStatus(paramData);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/30 17:07
	 * 获取已经未完成的 订单
	 * */
	public List<AppointmentOrder> getAppointmentOrderFinish(Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("userId", userId);
		paramData.put("orderStatus",3);
		return appointmentOrderDao.getMyAppointmentOrderByUserIdOrderStatus(paramData);
	}
	

}
