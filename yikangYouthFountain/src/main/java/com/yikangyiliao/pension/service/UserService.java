package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.UserManager;


@Service(value="userService")
public class UserService {
	
	@Autowired
	private UserManager userManager;

	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 注册用户及保存用户信息
	 * **/
	public Map<String,Object> saveRegisterUserAndSaveServiceInfo(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("loginName")
			&&paramData.containsKey("passWord")
			&&paramData.containsKey("userName")
			&&paramData.containsKey("userPosition") //职位
			&&paramData.containsKey("jobCategory") //全职，兼职
//			&&paramData.containsKey("provenceCode")
			&&paramData.containsKey("cityCode")
			&&paramData.containsKey("districtCode")
			&&paramData.containsKey("addressDetail")
			&&paramData.containsKey("photoUrl")
			){
			String loginName=paramData.get("loginName").toString();
			User u=userManager.getUserByLoginName(loginName);
			if(null == u){
				
				Long currentDateTime=Calendar.getInstance().getTimeInMillis();
				
				String passWord=paramData.get("passWord").toString();
				String userName=paramData.get("userName").toString();
				String userPosition=paramData.get("userPosition").toString();
				String jobCategory=paramData.get("jobCategory").toString();
//				String provenceCode=paramData.get("provenceCode").toString();
				String cityCode=paramData.get("cityCode").toString();
				String districtCode=paramData.get("districtCode").toString();
				String addressDetail=paramData.get("addressDetail").toString();
				String photoUrl=paramData.get("photoUrl").toString();
				
				User user=new User();
				user.setUserName(userName);
				user.setLoginName(loginName);
				user.setLoginPassword(passWord);
				user.setCreateTime(currentDateTime);
				user.setSalt("000000");
				user.setLoginTime(currentDateTime);
				
				
				userManager.insertUserSelective(user);
				
				UserServiceInfo userServiceInfo=new UserServiceInfo();
				userServiceInfo.setUserId(user.getUserId());
				userServiceInfo.setPhotoUrl(photoUrl);
				userServiceInfo.setProvenceCode(Long.valueOf("0"));
				userServiceInfo.setCityCode(Long.valueOf(cityCode));
				userServiceInfo.setAddressDetail(addressDetail);
				userServiceInfo.setDistrictCode(Long.valueOf(districtCode));
				userServiceInfo.setUserPostion(Long.valueOf(userPosition));
				userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
				userServiceInfo.setCreateTime(currentDateTime);
				userServiceInfo.setUpdateTime(currentDateTime);
				userServiceInfo.setIsDelete(Byte.valueOf("0"));
				userServiceInfo.setUserServiceName(userName);
				
				userManager.insertUserServiceSelective(userServiceInfo);
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.operationException.userDuplicateException.errorCode);
				rtnData.put("message", ExceptionConstants.operationException.userDuplicateException.errorMessage);
			}
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 注册用户
	 * **/
	public Map<String,Object> registerUser(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("loginName")
			&&paramData.containsKey("passWord")
			){
			
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String loginName=paramData.get("loginName").toString();
			String passWord=paramData.get("passWord").toString();
			
			User user=new User();
			user.setUserName("");
			user.setLoginName(loginName);
			user.setLoginPassword(passWord);
			user.setCreateTime(currentDateTime);
			user.setSalt("000000");
			user.setLoginTime(currentDateTime);
			
			userManager.insertUserSelective(user);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 注册用户及保存用户信息
	 * **/
	public Map<String,Object> saveServiceUserInfo(Map<String,Object> paramData){
		
		//用户id 在paramData中存着
		
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("userPostion") //职位
			&&paramData.containsKey("jobCategory") //全职，兼职
			&&paramData.containsKey("provenceCode")
			&&paramData.containsKey("cityCode")
			&&paramData.containsKey("districtCode")
			&&paramData.containsKey("addressDetail")
			&&paramData.containsKey("photoUrl")
			&&paramData.containsKey("userName")
			){
			
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String userId=paramData.get("userId").toString();
			String userPostion=paramData.get("userPostion").toString();
			String jobCategory=paramData.get("jobCategory").toString();
//			String provenceCode=paramData.get("provenceCode").toString();
			String cityCode=paramData.get("cityCode").toString();
			String districtCode=paramData.get("districtCode").toString();
			String addressDetail=paramData.get("addressDetail").toString();
			String photoUrl=paramData.get("photoUrl").toString();
			String userName=paramData.get("userName").toString();
			

			
			UserServiceInfo userServiceInfo=new UserServiceInfo();
			userServiceInfo.setUserId(Long.parseLong(userId));
			userServiceInfo.setPhotoUrl(photoUrl);
			userServiceInfo.setProvenceCode(Long.valueOf("0"));
			userServiceInfo.setCityCode(Long.valueOf(cityCode));
			userServiceInfo.setAddressDetail(addressDetail);
			userServiceInfo.setDistrictCode(Long.valueOf(districtCode));
			userServiceInfo.setUserPostion(Long.valueOf(userPostion));
			userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
			userServiceInfo.setCreateTime(currentDateTime);
			userServiceInfo.setUpdateTime(currentDateTime);
			userServiceInfo.setUserServiceName(userName);
			
			User user=new User();
			user.setUserId(Long.valueOf(userId));
			user.setUserName(userName);
			userManager.updateUser(user);
			
			userManager.insertUserServiceSelective(userServiceInfo);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 修改用户信息
	 * **/
	public Map<String,Object> updateUser(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("loginName")
			&&paramData.containsKey("passWord")
			){
			
//			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String loginName=paramData.get("loginName").toString();
			String passWord=paramData.get("passWord").toString();
			
			User user=new User();
			//user.setUserName("未填写");
			user.setLoginName(loginName);
			user.setLoginPassword(passWord);
			
			userManager.insertUserSelective(user);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 修改用户信息
	 * **/
	public Map<String,Object> getUserServiceInfoByUserId(Map<String,Object> paramData){
			
			Map<String,Object> rtnData=new HashMap<String,Object>();
			
			String userId=paramData.get("userId").toString();
			
			Map<String,Object> userServiceInfo=userManager.getUserServiceInfoByUserId(Long.valueOf(userId));
			rtnData.put("data", userServiceInfo);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			return rtnData;
	}
	
	
	
	
}
