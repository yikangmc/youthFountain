package com.yikangyiliao.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikangyiliao.base.encryption.AES;
import com.yikangyiliao.base.utils.AccessTiketCheckout;
import com.yikangyiliao.base.utils.ApplicationContextUtil;
import com.yikangyiliao.base.utils.InterfaceUtil;
import com.yikangyiliao.pension.common.error.ExceptionConstants;


@Controller
public class ServiceController {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private Logger logger=Logger.getLogger(ServiceController.class);

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/service/{serverviceCode}")
	@ResponseBody
	public Map<String,Object> doMethod(@PathVariable String serverviceCode,String appId,String accessTicket, String paramData,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		SimpleDateFormat sdf =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		System.out.println("controller 接收到请求  "+sdf.format(new Date()));
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		if (null != serverviceCode) {

			String beanName = InterfaceUtil.getBeanNameByServiceCode(serverviceCode);

			String methodName = InterfaceUtil.getMethodNameByServiceCode(serverviceCode);

			if (null != beanName) {
				if (null != methodName) {

					Object invokObject = ApplicationContextUtil.applicationContext.getBean(beanName);

					try {
						Method returnMethod = invokObject.getClass().getMethod(methodName, Map.class);

						Map<String, Object> paramMap = new HashMap<String, Object>();
						
						if(null != paramData && paramData.length()>=0){
							if(paramData.length()>5){
								paramData=AES.Decrypt(paramData, "1234567890abcDEF");
								logger.debug("serviceController --> 接收到的paramData数据："+paramData);
								paramMap=objectMapper.readValue(paramData, Map.class);
							}
						}
						
						if(!serverviceCode.equals("login") && !serverviceCode.equals("registerUserAndSaveServiceInfo")){
//						if(null != request.getParameter("accessTicket")){
							String accessTiket=request.getParameter("accessTicket");
							String UD =AccessTiketCheckout.getAccessTiketUD(accessTiket);
							String LDT=AccessTiketCheckout.getAccessTiketLDT(accessTiket);
							String MC =AccessTiketCheckout.getAccessTiketMC(accessTiket);
							
							paramMap.put("userId",UD);
							paramMap.put("loginDateTime",LDT);
							paramMap.put("machineCode",MC);
						}
						try{
							rtnMap = (Map<String, Object>) returnMethod.invoke(invokObject, paramMap);

						}catch(Exception e){
							logger.error(e.getMessage());
							e.printStackTrace();
							//ExceptionInfo e2=(ExceptionInfo)e;
							rtnMap.put("status",ExceptionConstants.systemException.systemException.errorCode);
							rtnMap.put("message",ExceptionConstants.systemException.systemException.errorMessage);
						}
						
						
						// 获取返回
						if(null != rtnMap.get("data")){
							Object data = rtnMap.get("data");
							String jsonStr="";
							if(!serverviceCode.equals("login")){
								 jsonStr = objectMapper.writeValueAsString(data);
							}else{
								jsonStr=data.toString();
							}
							
							String enStr = AES.Encrypt(jsonStr, "1234567890abcDEF");
							rtnMap.put("data", enStr);
							//System.out.println(AES.Decrypt(enStr, "1234567890abcDEF"));
						}
						return rtnMap;
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonGenerationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			rtnMap.put("status","999999");
			rtnMap.put("message", "没有对应服务！");
			return rtnMap;
		}
		rtnMap.put("status","999999");
		rtnMap.put("message", "易康现在有点忙！");
		return rtnMap;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String doMethodw2(ModelMap map, HttpServletRequest request) {

		return "{status:'999999',message:'易康现在有点忙！',data:''}";
	}

}
