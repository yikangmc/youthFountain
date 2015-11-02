package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AppointmentOrderMedicinalApparatusMapDao;
import com.yikangyiliao.pension.entity.AppointmentOrderMedicinalApparatusMap;

@Component
public class AppointmentOrderMedicinalApparatusMapManager {
	
	
	@Autowired
	private AppointmentOrderMedicinalApparatusMapDao appointmentOrderMedicinalApparatusMapDao;
	
	
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/10/27 17:07
	 * @desc 添加
	 * 
	 * **/
	public int insertSelective(AppointmentOrderMedicinalApparatusMap record){
		return appointmentOrderMedicinalApparatusMapDao.insertSelective(record);
	}
	
}
