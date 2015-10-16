package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.UserServiceInfo;

public interface UserServiceInfoDao {
    int deleteByPrimaryKey(Long userServiceInfoId);

    int insert(UserServiceInfo record);

    int insertSelective(UserServiceInfo record);

    UserServiceInfo selectByPrimaryKey(Long userServiceInfoId);

    int updateByPrimaryKeySelective(UserServiceInfo record);

    int updateByPrimaryKey(UserServiceInfo record);
    
    /**
     * @author liushuaic
     * @date 2015/08/28 11:59
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
    Map<String,Object> getUserServiceInfoByUserId(Long userIds);
    
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/09/17 14:46
     * @desc 获取所有评估师
     * */
    List<UserServiceInfo> getPingGuServiceAll();
    
    
    
    /**
     * @author liushuaic
     * @date 2015/10/14 19:59
     * @desc 获取评估师，根据评估师id
     * **/
    Map<String,Object> getPingGuServicerByUserId(Long userId);
    
    
    
}