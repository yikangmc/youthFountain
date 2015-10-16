package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SeniorAccountDao;
import com.yikangyiliao.pension.entity.SeniorAccount;


/**
 * @author liushuaic
 * @Date 2015/08/13 14:43
 * **/
@Component
public class SeniorAccountManager {
	
	@Autowired
	private SeniorAccountDao seniorAccountDao;
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/13 14:44
	 * 获取某一个患者，根据患者id
	 * 
	 * */
	public SeniorAccount selectByPrimaryKey(Long seniorId){
		return seniorAccountDao.selectByPrimaryKey(seniorId);
	}

}
