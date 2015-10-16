package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class SeniorAccountServiceTest {

	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-01 接口保存患者信息
	 * */
	@Test
	public void TestSaveSeniroAccount(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("appId", "");
			paramData.put("accessTiket", "ae7433528cdd54dc76e922c1d612c82dfcfc343a64e68012c34c1b74c4cd73dd5e4c7afd323d91954ba85f0a1bf9bb45");
			paramData.put("machineCode","123123");
			
			SendRequest.sendPost("00-01-03?appId=00-01&machineCode=123123&accessTiket=ae7433528cdd54dc76e922c1d612c82dfcfc343a64e68012c34c1b74c4cd73dd5e4c7afd323d91954ba85f0a1bf9bb45",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-03 查询某一个用户下的所有人
	 * getSeniorAccountByUserId
	 * */
	@Test
	public void TestGetSeniorAccountByUserId(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			//paramData.put("userId",1);
			
			SendRequest.sendPost("00-01-03",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
