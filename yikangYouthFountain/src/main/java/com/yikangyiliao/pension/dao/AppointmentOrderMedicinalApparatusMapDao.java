package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.AppointmentOrderMedicinalApparatusMap;

public interface AppointmentOrderMedicinalApparatusMapDao {
    int deleteByPrimaryKey(Long appointmentOrderMedicinalApparatuMapId);

    int insert(AppointmentOrderMedicinalApparatusMap record);

    int insertSelective(AppointmentOrderMedicinalApparatusMap record);

    AppointmentOrderMedicinalApparatusMap selectByPrimaryKey(Long appointmentOrderMedicinalApparatuMapId);

    int updateByPrimaryKeySelective(AppointmentOrderMedicinalApparatusMap record);

    int updateByPrimaryKey(AppointmentOrderMedicinalApparatusMap record);
}