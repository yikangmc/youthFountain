package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.yikang.base.SendRequest;

public class ServicerServiceTest {

	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015-10-15 11:54
	 * @desc 测试获取服务人员
	 * */
	@Test
	public void getAssessmentServiceTest(){
		
		try {
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("districtCode","110108");
			paramData.put("mapPositionAddress","新华联国际");
			paramData.put("detailAddress","翠微路2号院");
			paramData.put("serviceDate","2015-10-23");
			paramData.put("custumerTimeQuantumId","2");
			
			SendRequest.sendPost("00-22-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015-10-15 11:54
	 * @desc 测试获取服务人员
	 * */
	@Test
	public void getServicerTest(){
		
		try {
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("districtCode","110108");
			paramData.put("mapPositionAddress","新华联国际");
			paramData.put("detailAddress","翠微路2号院");
			paramData.put("serviceDate","2015-10-23");
			paramData.put("custumerTimeQuantumId","2");
			paramData.put("serviceItemId","1");
			
			SendRequest.sendPost("00-22-02?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
