package com.yikangyiliao.pension.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.manager.LocationManager;

/**
 * @author liushuaic
 * @date 2015/10/19 14:51
 * @desc 地图查询
 * 
 * 
 * */

@Service(value="locationService")
public class LocationService {
	
	@Autowired
	private LocationManager locationManager;

}
