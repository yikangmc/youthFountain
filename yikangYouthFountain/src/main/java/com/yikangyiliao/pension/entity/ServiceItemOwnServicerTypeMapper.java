package com.yikangyiliao.pension.entity;

import com.yikangyiliao.pension.entity.ServiceItemOwnServicerType;

public interface ServiceItemOwnServicerTypeMapper {
    int deleteByPrimaryKey(Long serviceItemOwnServicerTypeId);

    int insert(ServiceItemOwnServicerType record);

    int insertSelective(ServiceItemOwnServicerType record);

    ServiceItemOwnServicerType selectByPrimaryKey(Long serviceItemOwnServicerTypeId);

    int updateByPrimaryKeySelective(ServiceItemOwnServicerType record);

    int updateByPrimaryKey(ServiceItemOwnServicerType record);
}