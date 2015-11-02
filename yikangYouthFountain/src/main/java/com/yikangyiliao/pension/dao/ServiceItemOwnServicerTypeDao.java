package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ServiceItemOwnServicerType;

public interface ServiceItemOwnServicerTypeDao {
    int deleteByPrimaryKey(Long serviceItemOwnServicerTypeId);

    int insert(ServiceItemOwnServicerType record);

    int insertSelective(ServiceItemOwnServicerType record);

    ServiceItemOwnServicerType selectByPrimaryKey(Long serviceItemOwnServicerTypeId);

    int updateByPrimaryKeySelective(ServiceItemOwnServicerType record);

    int updateByPrimaryKey(ServiceItemOwnServicerType record);
    
    /**
     * 
     * @author liushuaic
     * @date 2015/10/29 17:49
     *  查询某一个服务类型，根据服务id
     * */
    

    ServiceItemOwnServicerType 	getServiceItemOwnServiceByServiceItemId(Long serviceItemId);
    
    
}