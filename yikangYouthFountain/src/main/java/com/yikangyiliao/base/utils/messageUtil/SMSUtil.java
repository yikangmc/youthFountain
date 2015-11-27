package com.yikangyiliao.base.utils.messageUtil;

import java.util.HashMap;
import com.cloopen.rest.sdk.CCPRestSDK;

/**
 * @author liushuaic
 * @date 2015/09/01 18:
 *  短信发送工具类
 *  使用的容联云通信
 * **/
public class SMSUtil {
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/01
	 * @param mobilePhoneNumber 手机号
	 * @param captcha  验证码
	 * @param waitTime 等待时间
	 * 
	 * ***/
	public static boolean sendMessage(String mobilePhoneNumber,String captcha,String waitTime){
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		//测试
		//restAPI.init("sandboxapp.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		//线上
		restAPI.init("app.cloopen.com", "8883");
		restAPI.setAccount("aaf98f894f73de3f014f87eed2540e2e", "01f347c0e8b8422d9b5db930098ea179");// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId("8a48b5514f73ea32014f87f0ff9b280e");// 初始化应用ID
		//result = restAPI.sendTemplateSMS("号码1,号码2等","模板Id" ,new String[]{"模板内容1","模板内容2"});
		result = restAPI.sendTemplateSMS(mobilePhoneNumber,"35100" ,new String[]{captcha,waitTime});

		System.out.println("SDKTestSendTemplateSMS result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
//			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
//			Set<String> keySet = data.keySet();
//			for(String key:keySet){
//				Object object = data.get(key);
//				System.out.println(key +" = "+object);
//			}
			return true;
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
			return false;
		}
		
	}
	
}
