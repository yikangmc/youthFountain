package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ServiceItemOwnServicerTypeDao;
import com.yikangyiliao.pension.dao.UserDao;
import com.yikangyiliao.pension.dao.UserInfoDao;
import com.yikangyiliao.pension.dao.UserServiceInfoDao;
import com.yikangyiliao.pension.entity.ServiceItemOwnServicerType;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.entity.UserServiceInfo;


@Component
public class UserManager {
	
	@Autowired
	private UserDao userDao;

	
	@Autowired
	private UserServiceInfoDao userServiceInfoDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private ServiceItemOwnServicerTypeDao serviceItemOwnServicerTypeDao;
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:20
	 * @desc 添加用户信息
	 * **/
	public int insertUserSelective(User user){
		return userDao.insertSelective(user);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:24
	 * @desc 添加服务人员信息
	 * */
	public int insertUserServiceSelective(UserServiceInfo userServiceInfo){
		return userServiceInfoDao.insertSelective(userServiceInfo);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 查询某一个用户
	 * **/
	public User selectByPrimaryKey(Long userId){
		return userDao.selectByPrimaryKey(userId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/26 11:09 修改用户信息
	 * */
	public int updateUser(User user){
		return userDao.updateByPrimaryKeySelective(user);
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/08/27 19:13 
	 * 查询某一个用户
	 * */
	public User getUserByLoginName(String loginName){
		return userDao.getUserByLoginName(loginName);
	}
	
	 /**
     * @author liushuaic
     * @date 2015/08/28 11:59
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
	public Map<String,Object> getUserServiceInfoByUserId(Long userId){
		return userServiceInfoDao.getUserServiceInfoByUserId(userId);
	}
	
	
    /**
     * @author liushuaic
     * @date 2015/09/07 13:41
     * @param userId 用户id
     * 
     * 获取某一个用户信息，根据用户id
     * **/
	public UserInfo getUserInfoByUserId(Long userId){
		return userInfoDao.getUserInfoByUserId(userId);
	}


	 /**
     * 
     * @author liushuaic
     * @date 2015/09/17 14:46
     * @desc 获取所有评估师
     * */
	public List<UserServiceInfo> getPingGuServiceAll(){
    	return userServiceInfoDao.getPingGuServiceAll();
    }

	 /**
    * @author liushuaic
    * @date 2015/10/14 20:03 
    * @desc 获取某一个评估人员
    * */
	public Map<String,Object> getPingGuServicerByUserId(Long userId){
		return userServiceInfoDao.getPingGuServicerByUserId(userId);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/30 14:49
	 * @desc 修改消费端用户信息，根据用户id
	 * 
	 * */
	public int updateUserInfoBySelective(UserInfo userInfo){
		return userInfoDao.updateByPrimaryKeySelective(userInfo);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/20 
	 * 获取有空闲时间的评估师
	 * */
	public List<UserServiceInfo> getPINGGUServicerByServiceDateCustumerQuantumId(String serviceDate,Long custumerQuantumId){
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("serviceDate", serviceDate);
		param.put("userPosition", 2);
		param.put("custumerQuantumId", custumerQuantumId);
		
		return userServiceInfoDao.getServicerByServiceDateCustumerTimeQuantumId(param);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/29 18:14 
	 * 获取某个服务的服务人员
	 * */
	public List<UserServiceInfo>  getServicerByServicerItemId(String serviceDate,Long custumerQuantumId,Long serviceItemId){
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("serviceDate", serviceDate);
		
		param.put("custumerQuantumId", custumerQuantumId);
		
		ServiceItemOwnServicerType serviceItemOwnServicerType=serviceItemOwnServicerTypeDao.getServiceItemOwnServiceByServiceItemId(serviceItemId);
		if(null != serviceItemOwnServicerType ){
			param.put("userPosition", serviceItemOwnServicerType.getServicerType());
		}else{
			
			return null;
		}
		
		
		return userServiceInfoDao.getServicerByServiceDateCustumerTimeQuantumId(param);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/12/31 10:36
	 * @desc 添加注册用户信息
	 * 
	 * ***/
	public int insertUserInfoSelective(UserInfo userInfo) {
		return userInfoDao.insertSelective(userInfo);
	}
	
    /**
     * @author liushuaic
     * @date 2015/11/18 15:29
     * @desc 邀请码，是根据用户id 获取的
     * 添加用户邀请码
     * */
	public int updateInvitationCodeByUserId(String invitationCode,Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("invitationCode", invitationCode);
		paramData.put("userId", userId);
		return userDao.updateInvitationCodeByUserId(paramData);
	}
	
	 /**
     * @author liushuaic
     * @date 2016/03/14 11:58
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
	public UserServiceInfo getUserServiceInfoByUserIdTwo(Long userId){
		return userServiceInfoDao.getUserServiceInfoByUserIdTwo(userId);
	}
	
}
