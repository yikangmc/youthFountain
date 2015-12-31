package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.CustumerTimeQuantumDao;
import com.yikangyiliao.pension.entity.CustumerTimeQuantum;

@Component
public class CustomerTimeQuantumManager {
	
	@Autowired
	private CustumerTimeQuantumDao custumerTimeQuantumDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/12/31 15:10
	 * 查询某一个时间点
	 * */
	public CustumerTimeQuantum selectByPrimaryKey(Long custumerTimeQuantumId){
		return custumerTimeQuantumDao.selectByPrimaryKey(custumerTimeQuantumId);
	}
	

}
