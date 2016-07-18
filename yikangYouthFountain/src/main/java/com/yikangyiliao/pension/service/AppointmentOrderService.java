package com.yikangyiliao.pension.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.common.utils.GenreateNumberUtils;
import com.yikangyiliao.pension.common.utils.map.MapUtils;
import com.yikangyiliao.pension.common.utils.map.model.GeoCodeModel;
import com.yikangyiliao.pension.entity.AppointmentOrder;
import com.yikangyiliao.pension.entity.AppointmentOrderMedicinalApparatusMap;
import com.yikangyiliao.pension.entity.CustumerTimeQuantum;
import com.yikangyiliao.pension.entity.Location;
import com.yikangyiliao.pension.entity.OrderServiceDetail;
import com.yikangyiliao.pension.entity.SeniorAccount;
import com.yikangyiliao.pension.entity.ServiceSchedule;
import com.yikangyiliao.pension.entity.TimeQuantum;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.AppointmentOrderManager;
import com.yikangyiliao.pension.manager.AppointmentOrderMedicinalApparatusMapManager;
import com.yikangyiliao.pension.manager.CustomerTimeQuantumManager;
import com.yikangyiliao.pension.manager.LocationManager;
import com.yikangyiliao.pension.manager.OrderServiceDetailManager;
import com.yikangyiliao.pension.manager.SeniorAccountManager;
import com.yikangyiliao.pension.manager.ServiceScheduleManager;
import com.yikangyiliao.pension.manager.TimeQuantumManager;
import com.yikangyiliao.pension.manager.UserFromManager;
import com.yikangyiliao.pension.manager.UserManager;
import com.yikangyiliao.pension.schedule.PersonnelDistribution;

@Service(value="appointmentOrderService")
public class AppointmentOrderService {

	
	@Autowired
	private AppointmentOrderManager appointmentOrderManager;
	
	@Autowired
	private OrderServiceDetailManager orderServiceDetailManager;
	
	@Autowired
	private PersonnelDistribution personnelDistribution;
	
	@Autowired
	private TimeQuantumManager timeQuantumManager;
	
	@Autowired
	private GenreateNumberUtils genreateNumberUtils;
	
	@Autowired
	private LocationManager locationManager;
	
	@Autowired
	private ServiceScheduleManager serviceScheduleManager;
	
	@Autowired
	private AppointmentOrderMedicinalApparatusMapManager appointmentOrderMedicinalApparatusMapManager; 
	
	@Autowired
	private SeniorAccountManager seniorAccountManager;
	
	@Autowired
	private CustomerTimeQuantumManager customerTimeQuantumManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserFromManager userFromManager;
	
	
	
	public Map<String,Object> addPointmentOrder(Map<String,Object> param) throws ParseException, InterruptedException{
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(	
			   //null != param.get("parentLinkAddress")
			 null != param.get("phoneNumber")
			//&& null != param.get("myPhoneNumber")
			&& null != param.get("nickName")
			&& null != param.get("appointmentDateTime")
			&& null != param.get("timeQuantumId")
			&& null != param.get("startTime")
			&& null != param.get("endTime")
//			&& null != param.get("provenceCode")
//			&& null != param.get("cityCode")
			&& null != param.get("districtCode")
			//&& null != param.get("longitude")
			//&& null != param.get("latitude")
			&& null != param.get("detailAddress")
			&& null != param.get("mapPostionAddress")
//			&& null != param.get("serviceCount")
			&& null != param.get("dataSource")
			&& null != param.get("dataGroup")
			&& null != param.get("linkUserName")
		){
			
				Long currentDateTimeMillis=Calendar.getInstance().getTimeInMillis();
				Date currentDate=Calendar.getInstance().getTime();
			
			
				AppointmentOrder appointmentOrder =new AppointmentOrder();
				
				 String parentLinkAddress	=  param.get("parentLinkAddress").toString();
				 String phoneNumber			=  param.get("phoneNumber").toString();
				 String myPhoneNumber		=  param.get("myPhoneNumber").toString();
				 String nickName			=  param.get("nickName").toString();
				 String appointmentDateTime	=  param.get("appointmentDateTime").toString();
				 String timeQuantumId		=  param.get("timeQuantumId").toString();
				 String districtCode		=  param.get("districtCode").toString();
				 String longitude			=  param.get("longitude").toString();
				 String latitude			=  param.get("latitude").toString();
				 String detailAddress		=  param.get("detailAddress").toString();
				 String mapPostionAddress	=  param.get("mapPostionAddress").toString();
				 String dataSource			=  param.get("dataSource").toString();
				 String dataGroup			=  param.get("dataGroup").toString();
				 String linkUserName		=  param.get("linkUserName").toString();
				
				
				 appointmentOrder.setParentLinkAddress(parentLinkAddress);
				 appointmentOrder.setPhoneNumber(phoneNumber);
				 appointmentOrder.setMyPhoneNumber(myPhoneNumber);
				 appointmentOrder.setNickName(nickName);
				 appointmentOrder.setAppointmentDateTime(DateUtils.getＭillisecond(appointmentDateTime));
				 appointmentOrder.setTimeQuanturmId(Long.valueOf(timeQuantumId));
				 appointmentOrder.setLinkUserName(linkUserName);
				 
				 //TimeQuantum timeQuantum=timeQuantumManager.getTimeQuantumsById(Long.valueOf(timeQuantumId));
				 CustumerTimeQuantum custumerTimeQuantum=customerTimeQuantumManager.selectByPrimaryKey(Long.valueOf(timeQuantumId));
				 
				 appointmentOrder.setStartTime(custumerTimeQuantum.getStartTime().toString());
				 appointmentOrder.setEndTime(custumerTimeQuantum.getEndTime().toString());
				 
				 
				//todo 
				 appointmentOrder.setProvenceCode("");
				 appointmentOrder.setCityCode("");
				 appointmentOrder.setDistrictCode("");
				 
				 
				 appointmentOrder.setLongitude(Double.valueOf(longitude));
				 appointmentOrder.setLatitude(Double.valueOf(latitude));
				 appointmentOrder.setDetailAddress(detailAddress);
				 appointmentOrder.setMapPostionAddress(mapPostionAddress);
				 appointmentOrder.setServiceCount(Integer.valueOf("1"));
				 appointmentOrder.setDataSource(Byte.valueOf(dataSource));
				 appointmentOrder.setDataGroup(Byte.valueOf(dataGroup));
				 appointmentOrder.setCreateTime(currentDateTimeMillis);
				 appointmentOrder.setUpdateTime(currentDateTimeMillis);
				 appointmentOrder.setOrderStatus(0);
				 appointmentOrder.setAssessmentId(-1l);
				 appointmentOrder.setOrderNumber("");
				 
				 
				 appointmentOrderManager.insertSelective(appointmentOrder);
				 
				 
				 OrderServiceDetail orderServiceDetail=new OrderServiceDetail();
				 orderServiceDetail.setOrderId(appointmentOrder.getAppointmentOrderId());
				 orderServiceDetail.setCreateTime(currentDateTimeMillis);
				 orderServiceDetail.setUpdateTime(currentDateTimeMillis);
				 orderServiceDetail.setCertainServiceUserStatus((byte)1);
				 orderServiceDetail.setServiceDetailStatus((byte)1);
				 orderServiceDetail.setTimeQuantumId(Long.valueOf(timeQuantumId));
				 orderServiceDetail.setAppointmentDate(appointmentDateTime);
				 orderServiceDetail.setServiceUserId(-1l);
				 orderServiceDetail.setServiceType((byte)0);
				 
				 orderServiceDetailManager.insertSelective(orderServiceDetail);
				 
				 personnelDistribution.orderIdsQueue.put(appointmentOrder.getAppointmentOrderId());
				 
				 rtnMap.put("orderId", appointmentOrder.getAppointmentOrderId());
			 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
		
		return rtnMap;
		
		
	}
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/15 10:16
	 * @desc 添加定单幷添加评估人员
	 * 
	 * **/
	public Map<String,Object> addPointmentOrderAndSubmitAssessment(Map<String,Object> param) throws ParseException, InterruptedException{
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(	
			 null != param.get("phoneNumber")
			&& null != param.get("appointmentDateTime")
			&& null != param.get("timeQuantumId")
			&& null != param.get("detailAddress")
			&& null != param.get("mapPositionAddress")
			&& null != param.get("dataSource")
			&& null != param.get("dataGroup")
			&& null != param.get("linkUserName")
			&& null != param.get("serviceUserId")
			&& null != param.get("districtCode")
			&& null != param.get("userId")
			&& null != param.get("serviceItemId")
		){
			
				
				 String serviceUserId		=  param.get("serviceUserId").toString();
				 String timeQuantumId		=  param.get("timeQuantumId").toString();
				 String appointmentDateTime	=  param.get("appointmentDateTime").toString();
				 String userId				=  param.get("userId").toString();
				
//				if(checkServicerTimeQuantum(Long.valueOf(timeQuantumId),appointmentDateTime,Long.valueOf(serviceUserId))){
					Long currentDateTimeMillis=Calendar.getInstance().getTimeInMillis();
				
					AppointmentOrder appointmentOrder = new AppointmentOrder();
					
					 String phoneNumber			=  param.get("phoneNumber").toString();
					 String districtCode		=  param.get("districtCode").toString();
					 String detailAddress		=  param.get("detailAddress").toString();
					 String mapPositionAddress	=  param.get("mapPositionAddress").toString();
					 String dataSource			=  param.get("dataSource").toString();
					 String dataGroup			=  param.get("dataGroup").toString();
					 String linkUserName		=  param.get("linkUserName").toString();
					 String myPhoneNumber 		=  param.get("myPhoneNumber").toString();
					 
					 String serviceItemId       =  param.get("serviceItemId").toString();
					 
					 
					SeniorAccount seniorAccount=new SeniorAccount();
					
					seniorAccount.setName(linkUserName);
					seniorAccount.setPhoneNo(phoneNumber);
					seniorAccount.setCreateTime(currentDateTimeMillis);
					seniorAccount.setUpdateTime(currentDateTimeMillis);
					seniorAccount.setCreateUserId(Long.valueOf(userId));
					seniorAccountManager.insertSelective(seniorAccount);

					 
					 
					 appointmentOrder.setCreateUserId(Long.valueOf(userId));
					 appointmentOrder.setSeniorId(seniorAccount.getSeniorId());
					 
					 appointmentOrder.setParentLinkAddress("");
					 appointmentOrder.setPhoneNumber(phoneNumber);
					 appointmentOrder.setMyPhoneNumber(myPhoneNumber);
					 appointmentOrder.setNickName("");
					 appointmentOrder.setAppointmentDateTime(DateUtils.getＭillisecond(appointmentDateTime));
					 appointmentOrder.setTimeQuanturmId(Long.valueOf(timeQuantumId));
					 appointmentOrder.setLinkUserName(linkUserName);
					 
					 // 冗余数据设置的评估师 
					 appointmentOrder.setAssessmentId(Long.valueOf(serviceUserId));
					 
					 CustumerTimeQuantum custumerTimeQuantum=customerTimeQuantumManager.selectByPrimaryKey(Long.valueOf(timeQuantumId));
					 
					 appointmentOrder.setStartTime(custumerTimeQuantum.getStartTime().toString());
					 appointmentOrder.setEndTime(custumerTimeQuantum.getEndTime().toString());
					 
					 appointmentOrder.setDetailAddress(detailAddress);
					 appointmentOrder.setMapPostionAddress(mapPositionAddress);
					 appointmentOrder.setServiceCount(Integer.valueOf("1"));
					 appointmentOrder.setDataSource(Byte.valueOf(dataSource));
					 appointmentOrder.setDataGroup(Byte.valueOf(dataGroup));
					 appointmentOrder.setCreateTime(currentDateTimeMillis);
					 appointmentOrder.setUpdateTime(currentDateTimeMillis);
					 appointmentOrder.setOrderStatus(0);
					 
					 // 生成订单编号
					appointmentOrder.setOrderNumber(genreateNumberUtils.generateAppointmentOrderNumber(serviceItemId));
					 
					String address="";
					Location city= locationManager.getCityByDistrictCode(districtCode);
					Location provence=locationManager.getProvenceByCityCode(districtCode);
					Location distirct=locationManager.getLocationByAdministrativeCode(districtCode);
					
					address=provence.getName()+city.getName()+distirct.getName()+mapPositionAddress+detailAddress;
					
					
					 
					 //设置经纬度
					if(address.length()>0){
						 try {
							 GeoCodeModel geoCodeModel=MapUtils.getGeoCodeModelByAddress(mapPositionAddress, city.getAdministrativeCode());
							 if(null != geoCodeModel && null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
								 //  TODO 有可能模糊地址对应的有多个这个问题要修改
								 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
								 String lngStr=lngLatStr.split(",")[0];
								 String latStr=lngLatStr.split(",")[1];
								 appointmentOrder.setLongitude(Double.valueOf(lngStr));
								 appointmentOrder.setLatitude(Double.valueOf(latStr));
							 }else{
								 geoCodeModel=MapUtils.getGeoCodeModelByAddress(mapPositionAddress, city.getAdministrativeCode());
								 if(null != geoCodeModel && null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
									 //  TODO 有可能模糊地址对应的有多个这个问题要修改
									 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
									 String lngStr=lngLatStr.split(",")[0];
									 String latStr=lngLatStr.split(",")[1];
									 appointmentOrder.setLongitude(Double.valueOf(lngStr));
									 appointmentOrder.setLatitude(Double.valueOf(latStr));;
								 }else{
									 appointmentOrder.setLongitude(0d);
									 appointmentOrder.setLatitude(0d);
								 }
							 }
							
						} catch (IOException e) {
							 appointmentOrder.setLongitude(0d);
							 appointmentOrder.setLatitude(0d);
							e.printStackTrace();
						}
					}
					 
					 
					 appointmentOrder.setAddress(address);
					 appointmentOrder.setProvenceCode(provence.getAdministrativeCode());
					 appointmentOrder.setCityCode(city.getAdministrativeCode());
					 appointmentOrder.setDistrictCode(districtCode);
					 
					 appointmentOrderManager.insertSelective(appointmentOrder);
					 
					 OrderServiceDetail orderServiceDetail=new OrderServiceDetail();
					 
					 orderServiceDetail.setOrderId(appointmentOrder.getAppointmentOrderId());
					 
					 orderServiceDetail.setCreateTime(currentDateTimeMillis);
					 orderServiceDetail.setUpdateTime(currentDateTimeMillis);
					 
					 orderServiceDetail.setCertainServiceUserStatus((byte)1);
					 orderServiceDetail.setServiceDetailStatus((byte)1);
					 
					 orderServiceDetail.setTimeQuantumId(Long.valueOf(timeQuantumId));
					 
					 // 设置某一项的具体服务
					 orderServiceDetail.setServiceItemId(Long.valueOf(serviceItemId));
					 
					 //设置服务预约时间
					 orderServiceDetail.setAppointmentDate(appointmentDateTime);
					 //设置真实上门服务时间
					 orderServiceDetail.setServiceDate(DateUtils.getDate(appointmentDateTime));
					 
					 // 设置服务人员的，服务id
					 orderServiceDetail.setServiceUserId(Long.valueOf(serviceUserId));
					 
					 //设置服务状态
					 orderServiceDetail.setServiceType((byte)0);
					 
					 //设置回复
					 orderServiceDetail.setServiceRecord("");
					 
					 
					 orderServiceDetailManager.insertSelective(orderServiceDetail);
					 
					 
					 //修改用户消费状态，为已消费
					 userFromManager.updateUserStatusSpentCost(Long.valueOf(userId));
					 
					 
					 
					 Map<String,Object> rtnData=new HashMap<String, Object>();
					 
					 rtnData.put("orderId", appointmentOrder.getAppointmentOrderId());
					 rtnMap.put("data",rtnData);
				 	 rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				 	 rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
				}else{
					// 服务人员，已经被选择
					rtnMap.put("status", ExceptionConstants.orderException.serviceUserHasBeenSelected.errorCode);
					rtnMap.put("message", ExceptionConstants.orderException.serviceUserHasBeenSelected.errorMessage);
				}
				 
//			}else{
//				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
//				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
//			}
		
		return rtnMap;
		
		
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/15 11:00
	 * 确认服务人员的服务时间，是否有问题
	 * 在再次提交时，对时间进行确认
	 * 
	 * **/
	public boolean checkServicerTimeQuantum(Long custumerTimeQuantumId,String serviceDate,Long serviceUserId){
		
		// TODO 1.重新确定距离时间 ，是否合适 。查询出来，最新的一个订单的，服务地址与  客户最近的。员工
		// TODO 2.如果没有，定单，就是住址。计算，最近的距离
		// 现阶段只做时间是否合适的校验
		
		ServiceSchedule serviceSchedule=serviceScheduleManager.selectServiceScheduleByCustumerTimeQuantumIdServiceDate(custumerTimeQuantumId,serviceDate,serviceUserId);
		
		if(null != serviceSchedule && serviceSchedule.getIsCanSelected()==1){
			return true;
		}
		
		return false;
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/09 15:46 
	 * 获取某一个，预约单的，评估师
	 * */
	public Map<String,Object> getServiceUserByOrderId(Map<String,Object> param){
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		if(null != param.get("orderId")){
			String orderId=param.get("orderId").toString();
			
			UserServiceInfo userServiceInfo=null;
			
			int i=0;
			while(i<6){
				try {
					
					OrderServiceDetail orderServiceDetail=orderServiceDetailManager.getEstimateOrderServiceDetailByOrderId(Long.valueOf(orderId));
					//判断是否，已经确定服务人员
					if(orderServiceDetail.getCertainServiceUserStatus()!=-1){
						break;
					}
					
					Thread.sleep(1000);
					i++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			if(i==6){
			 	rtnMap.put("status", "001111");
			 	rtnMap.put("message", "没有分配到合适的联系人！");
			}else{
				rtnMap.put("serviceUser", userServiceInfo);
			 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}
			

			
		}else{
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return rtnMap;
	
	}
	
	/**
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/10/27 15:53
	 * 保存单项服务
	 * **/
	public Map<String,Object> addApointmentOrderForServiceItem(Map<String,Object> param) throws ParseException{
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(	
			 null != param.get("phoneNumber")
			&& null != param.get("appointmentDateTime")
			&& null != param.get("timeQuantumId")
			&& null != param.get("districtCode")
			&& null != param.get("detailAddress")
			&& null != param.get("mapPositionAddress")
			&& null != param.get("dataSource")
			&& null != param.get("dataGroup")
			&& null != param.get("linkUserName")
			&& null != param.get("serviceUserId")// 服务人员id
			&& null != param.get("serviceItemId")// 某项目服务id
		){
			
				
				 String serviceUserId		=  param.get("serviceUserId").toString();
				 String timeQuantumId		=  param.get("timeQuantumId").toString();
				 String appointmentDateTime	=  param.get("appointmentDateTime").toString();
				
				//if(checkServicerTimeQuantum(Long.valueOf(timeQuantumId),appointmentDateTime,Long.valueOf(serviceUserId))){
					Long currentDateTimeMillis=Calendar.getInstance().getTimeInMillis();
				
					AppointmentOrder appointmentOrder = new AppointmentOrder();
					
					 String phoneNumber			=  param.get("phoneNumber").toString();
					 
					 
					 String districtCode		=  param.get("districtCode").toString();
					 String detailAddress		=  param.get("detailAddress").toString();
					 String mapPositionAddress	=  param.get("mapPositionAddress").toString();
					 String dataSource			=  param.get("dataSource").toString();
					 //String dataGroup			=  param.get("dataGroup").toString();
					 String linkUserName		=  param.get("linkUserName").toString();
					 String serviceItemId		= param.get("serviceItemId").toString();
					 
					 appointmentOrder.setParentLinkAddress("");
					 appointmentOrder.setPhoneNumber(phoneNumber);
					 appointmentOrder.setMyPhoneNumber("");
					 appointmentOrder.setNickName("");
					 appointmentOrder.setAppointmentDateTime(DateUtils.getＭillisecond(appointmentDateTime));
					 appointmentOrder.setTimeQuanturmId(Long.valueOf(timeQuantumId));
					 appointmentOrder.setLinkUserName(linkUserName);
					 
					 // 冗余数据设置的评估师 
					 appointmentOrder.setAssessmentId(Long.valueOf(serviceUserId));
					 
					 TimeQuantum timeQuantum=timeQuantumManager.getTimeQuantumsById(Long.valueOf(timeQuantumId));
					 appointmentOrder.setStartTime(timeQuantum.getStartTime().toString());
					 appointmentOrder.setEndTime(timeQuantum.getEndTime().toString());
					 
					 appointmentOrder.setDetailAddress(detailAddress);
					 appointmentOrder.setMapPostionAddress(mapPositionAddress);
					 appointmentOrder.setServiceCount(Integer.valueOf("1"));
					 appointmentOrder.setDataSource(Byte.valueOf(dataSource));
					 
					 //设置服务分类为2， 预约单项服务
					 appointmentOrder.setDataGroup(Byte.valueOf("2"));
					 
					 appointmentOrder.setCreateTime(currentDateTimeMillis);
					 appointmentOrder.setUpdateTime(currentDateTimeMillis);
					 // 生成订单编号
					 appointmentOrder.setOrderNumber(genreateNumberUtils.generateAppointmentOrderNumber());
					 
					 String address="";
					Location city= locationManager.getCityByDistrictCode(districtCode);
					Location provence=locationManager.getProvenceByCityCode(districtCode);
					Location distirct=locationManager.getLocationByAdministrativeCode(districtCode);
					
					address=provence.getName()+city.getName()+distirct.getName()+mapPositionAddress+detailAddress;
					
					
					 
					 //设置经纬度
					if(address.length()>0){
						 try {
							 GeoCodeModel geoCodeModel=MapUtils.getGeoCodeModelByAddress(mapPositionAddress+detailAddress, city.getAdministrativeCode());
							 if(null != geoCodeModel && null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
								 //  TODO 有可能模糊地址对应的有多个这个问题要修改
								 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
								 String lngStr=lngLatStr.split(",")[0];
								 String latStr=lngLatStr.split(",")[1];
								 appointmentOrder.setLongitude(Double.valueOf(lngStr));
								 appointmentOrder.setLatitude(Double.valueOf(latStr));
							 }else{
								 geoCodeModel=MapUtils.getGeoCodeModelByAddress(mapPositionAddress, city.getAdministrativeCode());
								 if(null != geoCodeModel && null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
									 //  TODO 有可能模糊地址对应的有多个这个问题要修改
									 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
									 String lngStr=lngLatStr.split(",")[0];
									 String latStr=lngLatStr.split(",")[1];
									 appointmentOrder.setLongitude(Double.valueOf(lngStr));
									 appointmentOrder.setLatitude(Double.valueOf(latStr));
								 }
							 }
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					 
					 
					 appointmentOrder.setAddress(address);
					 appointmentOrder.setProvenceCode(provence.getAdministrativeCode());
					 appointmentOrder.setCityCode(city.getAdministrativeCode());
					 appointmentOrder.setDistrictCode(districtCode);
					 appointmentOrder.setOrderStatus(0);
					 
					 appointmentOrderManager.insertSelective(appointmentOrder);
					 
					 OrderServiceDetail orderServiceDetail=new OrderServiceDetail();
					 
					 orderServiceDetail.setOrderId(appointmentOrder.getAppointmentOrderId());
					 
					 orderServiceDetail.setCreateTime(currentDateTimeMillis);
					 orderServiceDetail.setUpdateTime(currentDateTimeMillis);
					 
					 orderServiceDetail.setCertainServiceUserStatus((byte)1);
					 orderServiceDetail.setServiceDetailStatus((byte)1);
					 
					 orderServiceDetail.setTimeQuantumId(Long.valueOf(timeQuantumId));
					 
					 
					 //设置服务预约时间
					 orderServiceDetail.setAppointmentDate(appointmentDateTime);
					 //设置真实上门服务时间
					 orderServiceDetail.setServiceDate(DateUtils.getDate(appointmentDateTime));
					 
					 // 设置服务人员的，服务id
					 orderServiceDetail.setServiceUserId(Long.valueOf(serviceUserId));
					 
					 //设置服务状态
					 orderServiceDetail.setServiceType((byte)0);
					 
					 //设置回复
					 orderServiceDetail.setServiceRecord("");
					 
					 //服务项目id
					 orderServiceDetail.setServiceItemId(Long.valueOf(serviceItemId));
					 
					 
					 
					 orderServiceDetailManager.insertSelective(orderServiceDetail);
					 
					 if(null != param.get("medicinalApparatuIds")){
						 
						 Long[] medicinalApparatuIds=(Long[]) param.get("medicinalApparatuIds");
						 
						 for(int i=0;i<medicinalApparatuIds.length;i++){
							 
							 AppointmentOrderMedicinalApparatusMap appointmentOrderMedicinalApparatusMap=new AppointmentOrderMedicinalApparatusMap();
							 
							 appointmentOrderMedicinalApparatusMap.setAppointmentOrderId(appointmentOrder.getAppointmentOrderId());
							 appointmentOrderMedicinalApparatusMap.setMedicinalApparatusId(medicinalApparatuIds[i]);
							 appointmentOrderMedicinalApparatusMap.setCreateTime(currentDateTimeMillis);
							 appointmentOrderMedicinalApparatusMap.setUpdateTime(currentDateTimeMillis);
							 appointmentOrderMedicinalApparatusMap.setOrderServiceDetailId(currentDateTimeMillis);
							 
							 appointmentOrderMedicinalApparatusMapManager.insertSelective(appointmentOrderMedicinalApparatusMap);
						 }
						
					 }
					 
					 
					 Map<String,Object> rtnData=new HashMap<String, Object>();
					 
					 rtnData.put("orderId", appointmentOrder.getAppointmentOrderId());
					 rtnMap.put("data",rtnData);
				 	 rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				 	 rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
//				}else{
//					// 服务人员，已经被选择
//					rtnMap.put("status", ExceptionConstants.orderException.serviceUserHasBeenSelected.errorCode);
//					rtnMap.put("message", ExceptionConstants.orderException.serviceUserHasBeenSelected.errorMessage);
//				}
				 
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
		
		return rtnMap;
		
	}
	
	
	/**
	 * 
	 * @author liushuaic
	 * @deate 2015/11/30 18:08
	 * 获取我所有的订单
	 * 
	 * */
	public ResponseMessage getMyAppointmentOrder(Map<String,Object> paramData){
		ResponseMessage responseMessage=new ResponseMessage();
		
		String userId=paramData.get("userId").toString();
		
		List<AppointmentOrder> data=appointmentOrderManager.getAppointmentOrderByUserId(Long.valueOf(userId));
		
		responseMessage.setData(data);
		responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
		responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
		return responseMessage;
		
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/30 18:00
	 * @desc 获取我完成的订单
	 * **/
	public ResponseMessage getAppointmentOrderFinish(Map<String,Object> paramData){
		ResponseMessage responseMessage=new ResponseMessage();
		String userId=paramData.get("userId").toString();
		
		List<AppointmentOrder> data=appointmentOrderManager.getAppointmentOrderFinish(Long.valueOf(userId));
		
		responseMessage.setData(data);
		
		responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
		responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
		
		return responseMessage;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016/01/05 17:56
	 * @desc 预订成功的信息返回接口
	 * */
	public ResponseMessage orderComplete(Map<String,Object> paramData){
		
		ResponseMessage responseMessage=new ResponseMessage();
		
		if(
			paramData.containsKey("userId")
			&&paramData.containsKey("orderId")
			&&paramData.containsKey("serviceItemId")
			){
			String orderId=paramData.get("orderId").toString();
			String serviceItemId=paramData.get("serviceItemId").toString();
			
			Map<String,Object> rtnData=new HashMap<String,Object>();
			
			
			AppointmentOrder appointmentOrder= appointmentOrderManager.getAppointmentOrderByOrderId(Long.valueOf(orderId));
			if(null != appointmentOrder){
			
				Map<String, Object> result=orderServiceDetailManager.getServiceDetailByOrderIdAndServiceItemId(Long.valueOf(serviceItemId),Long.valueOf(orderId));
				
				if(null!= result){
					
					String serviceUserId=result.get("serviceUserId").toString();
					
					Map<String,Object> userServiceInfo=userManager.getPingGuServicerByUserId(Long.valueOf(serviceUserId));
					
					rtnData.put("userServiceInfo", userServiceInfo);
					rtnData.put("orderDetail", result);
					rtnData.put("appointmentOrder", appointmentOrder);
					
					responseMessage.setData(rtnData);
					responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
					responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
					
				}else{
					responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
					responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
				}
				
			}else{
				responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
				responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
			}
			
		}else{
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return responseMessage;
		
	}
	
	
}
