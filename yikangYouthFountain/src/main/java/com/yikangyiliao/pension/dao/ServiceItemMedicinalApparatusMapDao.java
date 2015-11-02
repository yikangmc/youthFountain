package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ServiceItemMedicinalApparatusMap;

public interface ServiceItemMedicinalApparatusMapDao {
    int deleteByPrimaryKey(Long serviceItemMedicinalApparatusMapId);

    int insert(ServiceItemMedicinalApparatusMap record);

    int insertSelective(ServiceItemMedicinalApparatusMap record);

    ServiceItemMedicinalApparatusMap selectByPrimaryKey(Long serviceItemMedicinalApparatusMapId);

    int updateByPrimaryKeySelective(ServiceItemMedicinalApparatusMap record);

    int updateByPrimaryKey(ServiceItemMedicinalApparatusMap record);
}