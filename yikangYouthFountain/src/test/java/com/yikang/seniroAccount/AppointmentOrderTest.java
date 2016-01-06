package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

/**
 * @author liushuaic
 * @date 2015/10/12 15:54
 * **/
public class AppointmentOrderTest {

	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/12 15:56
	 * 测试添加预约单
	 * **/
	@Test
	public void testAddAppointmentOrder(){
		try {

			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("parentLinkAddress","11");
			paramData.put("phoneNumber","11");
			paramData.put("myPhoneNumber","11");
			paramData.put("nickName","11");
			paramData.put("appointmentDateTime","2015-01-01");
			paramData.put("timeQuantumId","11");
			paramData.put("startTime","11");
			paramData.put("endTime","11");
			paramData.put("provenceCode","11");
			paramData.put("cityCode","11");
			paramData.put("districtCode","11");
			paramData.put("longitude","11");
			paramData.put("latitude","11");
			paramData.put("detailAddress","11");
			paramData.put("mapPostionAddress","11");
			paramData.put("serviceCount","11");
			paramData.put("dataSource","11");
			paramData.put("dataGroup","11");
			
			
			
			
			SendRequest.sendPost("00-21-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/12 15:56
	 * 测试添加预约单
	 * **/
	@Test
	public void addPointmentOrderAndSubmitAssessmentTest(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			// 联系电话
			paramData.put("phoneNumber","11");
			
			//服务时间
			paramData.put("appointmentDateTime","2015-10-23");
			//时间段id
			paramData.put("timeQuantumId","3");
			//联系人名称
			paramData.put("linkUserName","11");
			//区县id
			paramData.put("districtCode","110108");

			//地图定位地址
			paramData.put("mapPostionAddress","实创大厦东区");
			//用户输入详细地址
			paramData.put("detailAddress","北京市海淀区信息号22号实创大厦东区");
			
			//服务人员id
			paramData.put("serviceUserId","1");
			
			paramData.put("dataSource","1");
			paramData.put("dataGroup","1");
			
			
			
			
			SendRequest.sendPost("00-21-03?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/10/12 15:56
	 * 测试添加预约单
	 * 
	 * **/
	@Test
	public void addApointmentOrderForServiceItemTest(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			// 联系电话
			paramData.put("phoneNumber","11");
			
			//服务时间
			paramData.put("appointmentDateTime","2015-10-23");
			//时间段id
			paramData.put("timeQuantumId","3");
			//联系人名称
			paramData.put("linkUserName","11");
			//区县id
			paramData.put("districtCode","110108");

			//地图定位地址
			paramData.put("mapPositionAddress","实创大厦东区");
			//用户输入详细地址
			paramData.put("detailAddress","北京市海淀区信息号22号实创大厦东区");
			
			//服务人员id
			paramData.put("serviceUserId","1");
			
			//serviceItemId 服务项目id
			paramData.put("serviceItemId","1");
			
			paramData.put("dataSource","1");
			paramData.put("dataGroup","1");
			
			
			SendRequest.sendPost("00-21-04?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void orderComplateTest(){
		Map<String,Object> paramData=new HashMap<String,Object>();
		
		try {
			
			paramData.put("orderId", 1);
			paramData.put("serviceItemId", 1);
			paramData.put("userId", 1);
			SendRequest.sendPost("00-21-05?1=1",paramData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
