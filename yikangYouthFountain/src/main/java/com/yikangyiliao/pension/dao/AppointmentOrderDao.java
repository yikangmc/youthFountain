package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.AppointmentOrder;

public interface AppointmentOrderDao {
    int deleteByPrimaryKey(Long appointmentOrderId);

    int insert(AppointmentOrder record);

    int insertSelective(AppointmentOrder record);

    AppointmentOrder selectByPrimaryKey(Long appointmentOrderId);

    int updateByPrimaryKeySelective(AppointmentOrder record);

    int updateByPrimaryKey(AppointmentOrder record);
    
    
    /**
     * @author liushuaic
     * @date 2015/10/08 15:14 
     * 修改定单状态
     * @param   orderStatus 定单状态
     * 			0：未进行
				1：进行中
				2：已完成
				3：已评价
				4：已结束
				5：退回
     * 			appointmentOrderId
     * **/
    int updateAppointmentOrderStatus(Map<String,Object> param);
    
    
    
    
    
    /**
     * @author liushuaic
     * @date 2015/10/09 18:08
     * @desc 查询某一个定单的评估师
     * 
     * ***/
    Map<String,Object> getUserServiceInfoByOrderId(Long orderId);
    
    
}


