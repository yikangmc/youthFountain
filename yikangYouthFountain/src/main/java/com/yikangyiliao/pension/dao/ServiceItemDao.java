package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.ServiceItem;

public interface ServiceItemDao {
    int deleteByPrimaryKey(Long serviceItemId);

    int insert(ServiceItem record);

    int insertSelective(ServiceItem record);

    ServiceItem selectByPrimaryKey(Long serviceItemId);

    int updateByPrimaryKeySelective(ServiceItem record);

    int updateByPrimaryKey(ServiceItem record);
    
    
    /**
     * @author liushuaic
     * @date 2015/10/27  14:25
     * 查询服务项目列表
     * */
    List<ServiceItem> selectServiceItemsListPage(Map<String,Object> param);
    
    /**
     * @author liushuaic
     * @date 2015/10/28 11:08
     * 查询服务详情
     * */
   Map<String,Object> selectServiceItemDescByServiceItemId(Long serviceItemId);
}