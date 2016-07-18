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
import org.springframework.util.StringUtils;

import com.yikang.base.SendRequest;
import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Activety;
import com.yikangyiliao.pension.entity.ActivetyComment;
import com.yikangyiliao.pension.manager.ActivetyManager;

@Service(value="activetyService")
public class ActivetyService {

	 
	
	@Autowired
	private  ActivetyManager activetyManager;
	
	
	/**
     * @author liushuaic
     * @date 2016-05-13 10:19
     * @desc 获取所有活动
     * **/
	public ResponseMessage<Object> getActivetys(Map<String,Object> paramMap){
		ResponseMessage<Object> resData=new ResponseMessage<Object>(); 
			
			Long userId=null;
			if(paramMap.containsKey("userId") && (!StringUtils.isEmpty(paramMap.get("userId")))){
				Long.valueOf(paramMap.get("userId").toString());
			}
		
		return resData;
		 
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-13 16:19
	 * @desc 获取某一个活动
	 * **/
	@SuppressWarnings("unchecked")
	public ResponseMessage<Activety> getActivetyByActivetyId(Map<String,Object> paramMap){
		ResponseMessage<Activety>  resData=new ResponseMessage<Activety>(); 
		if(
			paramMap.containsKey("activetyId")  && (!StringUtils.isEmpty(paramMap.get("activetyId")))
			&& paramMap.containsKey("userId")  && (!StringUtils.isEmpty(paramMap.get("userId")))
		){
			Long activetyId=Long.valueOf(paramMap.get("activetyId").toString());
//			Activety activety=activetyManager.selectByPrimaryKey(activetyId);
			Activety activety=activetyManager.getActivetysDetailById(null, activetyId);
			resData.setData(activety);
		}else{
		}
		return resData;
	}
	
	/**
	 * @author liushuaic
	 * @date 
	 * @desc 添加活动
	 * **/
	public ResponseMessage<Activety> insertActivety(Map<String,Object> paramMap){
		ResponseMessage<Activety> resData=new ResponseMessage<Activety>();
		if(
			   paramMap.containsKey("title")
			&& paramMap.containsKey("content")
			&& paramMap.containsKey("startTime")
			&& paramMap.containsKey("endTime")
			&& paramMap.containsKey("entryStartTime")
			&& paramMap.containsKey("entryEndTime")
			&& paramMap.containsKey("personNumber")
			&& paramMap.containsKey("cost")
			&& paramMap.containsKey("activetyMode")
		 ){
			String title=paramMap.get("title").toString();
			String content=paramMap.get("content").toString();
						
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return resData;
	}
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016-05-17 18:33
	 * @desc 添加我参与的活动
	 * 
	 * **/
	public ResponseMessage<String> insertMyAcitivety(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(paramMap.containsKey("activetyId")){
			
			
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-18 16:34
	 * @desc 文章评论
	 * **/
	public ResponseMessage<String> insertActivetyComment(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(
				paramMap.containsKey("activetyId")
			&& paramMap.containsKey("content")
			){
			
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Long activetyId=Long.valueOf(paramMap.get("activetyId").toString());
			String content=paramMap.get("content").toString();
			
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-19 16:39
	 * @desc 获取活动的评论列表
	 * ***/
	public ResponseMessage<List<ActivetyComment>> getActivetyCommentByActivetyId(Map<String,Object> paramMap){
		ResponseMessage<List<ActivetyComment>> resData=new ResponseMessage<List<ActivetyComment>>();
		if(
				paramMap.containsKey("activetyId")
		 ){
			Long activetyId=Long.valueOf(paramMap.get("activetyId").toString());
//			List<ActivetyComment> data=activetyCommentManager.getActivetyCommentList(activetyId);
//			resData.setMessage("获取成功！");
//			resData.setData(data);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23 10:57
	 * @desc 获取我参加的活动列表
	 * **/
	public ResponseMessage<List<Activety>> getActiveyByJoinUserId(Map<String,Object> paramMap){
		
		ResponseMessage<List<Activety>> resData=new ResponseMessage<List<Activety>>();
		
		if(paramMap.containsKey("userId")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return resData;
	}
	
	
	
	
	
	
	
}
