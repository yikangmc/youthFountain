package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.AliasFactory;
import com.yikangyiliao.base.utils.InvitationCodeGnerateUtil;
import com.yikangyiliao.base.utils.messageUtil.SMSUtil;
import com.yikangyiliao.base.utils.messageUtil.im.Message;
import com.yikangyiliao.base.utils.messageUtil.im.MessageQueue;
import com.yikangyiliao.pension.common.cache.RedisCache;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserFrom;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.UserFromManager;
import com.yikangyiliao.pension.manager.UserManager;

@Service(value = "userService")
public class UserService {

	@Autowired
	private UserManager userManager;

	@Autowired
	private UserFromManager userFromManager;

	@Autowired
	private RedisCache redisCache;
	

	/**
	 * @author liushuaic
	 * @date 2015/11/20 10:51
	 * @desc 注册用户 手机号，验证码，邀请码
	 */
	public ResponseMessage registerUser(Map<String, Object> paramData) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (paramData.containsKey("mobileNumber") && paramData.containsKey("validateCode")) {

			Long currentDateTimeMillis = Calendar.getInstance().getTimeInMillis();
			String phoneNumber = paramData.get("mobileNumber").toString();
			String validateCode = paramData.get("validateCode").toString();
			
			/**
			 * @author liushuaic TODO 添加验证码校验
			 */

			boolean isPass = false;

//			String storeValidateCode = redisCache.getStringByStringKey(phoneNumber);
			String storeValidateCode = null;
			if (storeValidateCode != null) {
				Long currentDateTime = Calendar.getInstance().getTimeInMillis();
				String[] storeValidateCodes = storeValidateCode.split("-");
				String sendDate = storeValidateCodes[0];
				String sendValidateCode = storeValidateCodes[1];

				if ((currentDateTime - Long.valueOf(sendDate)) > 60000) {
					isPass = false;
					responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
					responseMessage.setMessage("验证码已经过期");
				} else {
					if (sendValidateCode.equals(validateCode)) {
						isPass = true;
					} else {
						responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
						responseMessage.setMessage("验证码，不正确！");
					}
				}

			}

			if (isPass) {

				// 邀请码
				String invitationCode = "-2";
				if (paramData.containsKey("invitationCode")) {
					invitationCode = paramData.get("invitationCode").toString();
				}
				User user = new User();
				user.setCreateTime(currentDateTimeMillis);
				user.setLoginName(phoneNumber);
				user.setUserName(phoneNumber);
				user.setSalt("-2");
				user.setAccessTiket("-2");
				String password="-2";
				
				if(paramData.containsKey("password")){
					password=paramData.get("password").toString();
				}
				user.setLoginPassword(password);
				
				userManager.insertUserSelective(user);

				UserFrom userFrom = new UserFrom();
				userFrom.setActiveTime(0L);
				userFrom.setCreateTime(currentDateTimeMillis);
				userFrom.setNumbers(0l);
				userFrom.setFromUrl("");
				userFrom.setInvitationCode(Integer.valueOf(invitationCode));
				userFrom.setCreateTime(currentDateTimeMillis);
				userFrom.setUpdateTime(currentDateTimeMillis);
				userFrom.setUserStatus((byte) 0);
				userFrom.setUserId(user.getUserId());
				userFromManager.insertSelective(userFrom);

				responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);

			}else{

			}

		} else {
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return responseMessage;
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/11/26 15:18
	 * @desc 获取验证码
	 * TODO 验证码校验，一分钟内的重复发送
	 * **/
	public ResponseMessage getValidateCode(Map<String, Object> paramData) {

		ResponseMessage responseMessage = new ResponseMessage();

		if (paramData.containsKey("mobileNumber")) {

			String mobileNumber = paramData.get("mobileNumber").toString();

			if (mobileNumber.length() == 11) {

				Long currentTimestamp = Calendar.getInstance().getTimeInMillis();

//				String validateCode = redisCache.getStringByStringKey(mobileNumber);
				String validateCode = null;
				boolean isPass = false;
				if (validateCode != null) {
 
					String[] validateCodes = validateCode.split("-");
					String validateDateTime = validateCodes[0];
					if ((currentTimestamp - Long.valueOf(validateDateTime)) > 60000) {
						isPass = true;
					}else {
						isPass=false;
						responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
						responseMessage.setMessage("验证码已发出!");
					}
				} else {
					isPass = true;
				}
				if (isPass) {
					Random random = new Random();
					int captcha = random.nextInt(99999);
					//SMSUtil.sendMessage(mobileNumber, captcha + "", "1");
					validateCode = currentTimestamp + "-" + captcha;
//					redisCache.putStringKeyStringVal(mobileNumber, validateCode);
					responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
					responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
				}

			}else{
				responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				responseMessage.setMessage("请输入手机号！");
			}

		}
		return responseMessage;

	}

	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/25 17:44 修改用户信息
	 * 
	 **/
	public Map<String, Object> getUserServiceInfoByUserId(Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		String userId = paramData.get("userId").toString();

		Map<String, Object> userServiceInfo = userManager.getUserServiceInfoByUserId(Long.valueOf(userId));
		rtnData.put("data", userServiceInfo);
		rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		return rtnData;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/30 14:58
	 * @desc 修改用户信息
	 * 
	 * */
	public ResponseMessage getUserInfoByUserId(Map<String,Object> paramData){
		ResponseMessage responseMessage=new ResponseMessage();
		String userId=paramData.get("userId").toString();
		
		UserInfo userInfo=userManager.getUserInfoByUserId(Long.valueOf(userId));
		
		responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
		responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
		responseMessage.setData(userInfo);
		
		
		return responseMessage;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/30 15:27
	 * @desc 修改用户信息， 根据用户id
	 * ***/
	public ResponseMessage updateUserInfoByUserId(Map<String,Object> paramData){
		ResponseMessage responseMessage=new ResponseMessage();
		
		String userId=paramData.get("userId").toString();
		
		UserInfo userInfo=new UserInfo();
		userInfo.setUserId(Long.valueOf(userId));
		
//		'user_info_id','bigint(20)','NO','PRI',NULL,'auto_increment'
//		'user_name','varchar(100)','NO','',NULL,''
//		'user_sex','tinyint(2)','NO','',NULL,''
//		'provence_code','varchar(45)','NO','',NULL,''
//		'city_code','varchar(45)','NO','',NULL,''
//		'district_code','varchar(45)','NO','',NULL,''
//		'address','varchar(100)','NO','',NULL,''
//		'create_at','bigint(20)','NO','',NULL,''
//		'update_at','bigint(20)','NO','',NULL,''
//		'user_id','bigint(20)','NO','',NULL,''
//		'is_delete','bigint(20)','NO','',NULL,''
//		'user_infos_col','varchar(45)','YES','',NULL,''

		Long currentDateTime=Calendar.getInstance().getTimeInMillis();
		userInfo.setUpdateAt(currentDateTime);
		
		if(paramData.containsKey("userName")){
			String userName=paramData.get("userName").toString();
			userInfo.setUserName(userName);
		}
		
		if(paramData.containsKey("userSex")){
			String userSex=paramData.get("userSex").toString();
			userInfo.setUserSex(Byte.valueOf(userSex));
		}
		
		if(paramData.containsKey("provenceCode")){
			String provenceCode=paramData.get("provenceCode").toString();
			userInfo.setProvenceCode(provenceCode);
		}
		
		if(paramData.containsKey("cityCode")){
			String cityCode=paramData.get("cityCode").toString();
			userInfo.setCityCode(cityCode);
		}
		
		if(paramData.containsKey("districtCode")){
			String districtCode=paramData.get("districtCode").toString();
			userInfo.setDistrictCode(districtCode);
		}
		
		if(paramData.containsKey("address")){
			String address=paramData.get("address").toString();
			userInfo.setAddress(address);
		}
		
		if(paramData.containsKey("mapPositionAdress")){
			String mapPositionAddress=paramData.get("mapPositionAddress").toString();
		}
		
		userManager.updateUserInfoBySelective(userInfo);
		
		responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
		responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
		return responseMessage;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/12/30 16:31
	 * @desc 注册用户为主页消费用户
	 * */
	public ResponseMessage registerUserForPortal(Map<String,Object> paramData){
		
		ResponseMessage responseMessage=new ResponseMessage();
		
		try{
			
			if(paramData.containsKey("loginName")  &&
			   paramData.containsKey("loginPassword")){
				
				
				
				
				Long curentTime=Calendar.getInstance().getTimeInMillis();
				
				User user=new User();
				
				String loginName=paramData.get("loginName").toString();
				String loginPassword=paramData.get("loginPassword").toString();
			   	User useri= userManager.getUserByLoginName(loginName);
				if(null == useri){
						
					user.setLoginName(loginName);
					user.setLoginPassword(loginPassword);
					user.setCreateTime(curentTime);
					user.setSalt("");
					user.setAccessTiket("");
					user.setUserName("");
					user.setLoginTime(curentTime);
					user.setPushAlias("");
					
					userManager.insertUserSelective(user);
					user.setUserName(null);
					user.setLoginName(null);
					user.setLoginPassword(null);
					user.setCreateTime(null);
					user.setSalt(null);
					user.setLoginTime(null);
					user.setPushAlias(AliasFactory.generateAliasByUser(user.getUserId().toString()));
					userManager.updateUser(user);  //修改用户推送
					//修改用户邀请码
					userManager.updateInvitationCodeByUserId(InvitationCodeGnerateUtil.generateInvitationCodeTwo(user), user.getUserId());
				
					UserInfo userInfo=new UserInfo();
					
					userInfo.setAddress("");
					userInfo.setCityCode("");
					userInfo.setDistrictCode("");
					userInfo.setIsDelete(0l);
					userInfo.setCreateAt(curentTime);
					userInfo.setUpdateAt(curentTime);
					userInfo.setUserId(user.getUserId());
					userInfo.setProvenceCode("");
					userInfo.setUserName("");
					userInfo.setUserSex(Byte.valueOf("-2"));
					
					userManager.insertUserInfoSelective(userInfo);
					responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
					responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
				}else{
					responseMessage.setStatus(ExceptionConstants.operationException.userDuplicateException.errorCode);
					responseMessage.setMessage(ExceptionConstants.operationException.userDuplicateException.errorMessage);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return responseMessage;
		
	}
	

}
