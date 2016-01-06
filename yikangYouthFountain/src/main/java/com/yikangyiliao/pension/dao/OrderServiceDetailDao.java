package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.OrderServiceDetail;

public interface OrderServiceDetailDao {
    int deleteByPrimaryKey(Long orderServiceDetailId);

    int insert(OrderServiceDetail record);

    int insertSelective(OrderServiceDetail record);

    OrderServiceDetail selectByPrimaryKey(Long orderServiceDetailId);

    int updateByPrimaryKeySelective(OrderServiceDetail record);

    int updateByPrimaryKey(OrderServiceDetail record);
    
    
    /**
     * @author liushuaic
     * @date 2015/10/12 11:03
     * @desc 获取某一个定单的评估人员
     * */
    OrderServiceDetail getEstimateOrderServiceDetailByOrderId(Long orderId);
    
    
    
    
    /**
     * @author liushuaic
     * @date 2015/10/12 11:03
     * @desc 获取某一项目服务的服务人员
     * @param Long orderId,
     * @param Long serviceItemId
     * */
    Map<String,Object> getServiceDetailByOrderIdAndServiceItemId(Map<String,Object> paramData);
    
    
    
}