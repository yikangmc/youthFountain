package com.yikangyiliao.pension.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.ForumPostTxtEditor;
import com.yikangyiliao.pension.manager.ForumPostTextEditorManager;

@Service(value = "forumPostTextEditorService")
public class ForumPostTextEditorService {

	@Autowired
	private ForumPostTextEditorManager forumPostTextEditorManager;

	/**
	 * @author liushuaic
	 * @date 2016-07-19 18:33
	 */
	public ResponseMessage<String> updateForumPostTxtEditorOwnUserIdByUniqueCode(Map<String, Object> paramMap) {

		ResponseMessage<String> responseMessage = new ResponseMessage<String>();
		if (paramMap.containsKey("userId") && paramMap.containsKey("uniqueCode")
				&& paramMap.containsKey("editorType") && (paramMap.get("editorType").toString().equals("3") && paramMap.containsKey("dataId"))) {
			Byte editorType = Byte.valueOf(paramMap.get("editorType").toString());
			Long userId = Long.valueOf(paramMap.get("userId").toString());
			String uniqueCode = paramMap.get("uniqueCode").toString();
			Long dataId=null;
			if(paramMap.containsKey("dataId")){
				String dataIdStr=paramMap.get("dataId").toString();
				dataId=Long.valueOf(dataIdStr);
			}

			int row = forumPostTextEditorManager.updateForumPostTxtEditorOwnUserIdEditorTypeByUniqueCode(userId,editorType,uniqueCode,dataId);
			if (row == 0) {
				responseMessage.setStatus(ExceptionConstants.forumPostTextEditException.unquieCodeIsOverdue.errorCode);
				responseMessage.setMessage(ExceptionConstants.forumPostTextEditException.unquieCodeIsOverdue.errorMessage);
			}
		} else {
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return responseMessage;

	}
	
	

	/**
	 * @author liushuaic
	 * @date 2016-07-21 13:52
	 * @desc 添加编辑扫码信息
	 */
	public ResponseMessage<String> inserSelective(Map<String, Object> paramMap) {
		ResponseMessage<String> responseMessage = new ResponseMessage<String>();
		if (paramMap.containsKey("uniqueCode")) {
			String uniqueCode = paramMap.get("uniqueCode").toString();
			forumPostTextEditorManager.insertSelective(uniqueCode);
		} else {
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
		}

		return responseMessage;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-07-21 15:33
	 * @desc 获取文章编辑信息 根据 唯一标识
	 * */
	public ResponseMessage<ForumPostTxtEditor> getForumPostTextByUniqueCode(Map<String,Object> paramMap){
		
		ResponseMessage<ForumPostTxtEditor>  responseMessage=new ResponseMessage<ForumPostTxtEditor>();
		
		if(paramMap.containsKey("uniqueCode")){
			String uniqueCode=paramMap.get("uniqueCode").toString();
			ForumPostTxtEditor fpte=forumPostTextEditorManager.getForumPostTxtByUniqueCode(uniqueCode);
			responseMessage.setData(fpte);
			return responseMessage;
			
		}else{
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return responseMessage;
		
	}
	
	
}
