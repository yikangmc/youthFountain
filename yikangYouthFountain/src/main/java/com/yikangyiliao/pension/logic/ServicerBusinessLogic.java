package com.yikangyiliao.pension.logic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.common.utils.map.model.MapResponse;
import com.yikangyiliao.pension.entity.UserServiceInfo;

/**
 * @author liushuaic
 * @date 2015/10/21 15:37
 * @desc 服务人员业务逻辑处理
 * 主要用于分配服务人员
 * 
 * **/
public class ServicerBusinessLogic{

	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/21 19:29
	 * @desc 处理服务人员
	 * 
	 * ***/
	public static UserServiceInfo disposeServicer(List<UserServiceInfo> userServiceInfos,MapResponse<LinkedHashMap<String,String>> distances){
		
		
		if(null != distances){
			List<LinkedHashMap<String,String>> dis=distances.getResults();
			
			Object[] distancesArray= dis.toArray();

			for(int i=0;i<distancesArray.length;i++){
				for(int j=i;j<distancesArray.length;j++){
					
					Map<String,String> d=(Map<String,String>)distancesArray[i];
					Map<String,String> d2=(Map<String,String>)distancesArray[j];
					int distance=Integer.valueOf(d.get("distance"));
					int distance2=Integer.valueOf(d2.get("distance"));
					Map<String,String> handOf=d;
					if(distance>distance2){
						distancesArray[i]=distancesArray[j];
						distancesArray[j]=handOf;
					}
					
				}
			}
			return computeUserServiceInfoScore(userServiceInfos,distancesArray);
			
		}
		
		return null;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/21 19:14
	 * @desc 计算服务人员得分
	 * @return UserServiceInfo 服务人员
	 * */
	public static UserServiceInfo computeUserServiceInfoScore(List<UserServiceInfo> data,Object[] datas){
		System.out.println(((Map<String,String>)datas[0]).get("origin_id").toString());
		 return data.get(Integer.valueOf(((Map<String,String>)datas[0]).get("origin_id").toString())-1);
		
	}
	
	
	
}
