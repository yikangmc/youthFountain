package com.yikang.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yikangyiliao.base.encryption.AES;
import com.yikangyiliao.pension.common.response.ResponseMessage;




/**
 * @author liushuaic
 * @date 2015/07/27 18:22
 * @发送请求工具类
 * **/

public class SendRequest {
	
	// 在线上
	
	private static String REQUEST_URL = "http://127.0.0.1:8080/yikangservice/service/";
	
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static Logger sendRequestLogger=LoggerFactory.getLogger(SendRequest.class);

	@SuppressWarnings("unchecked")
	public static void sendPost(String serviceCode,Map<String,Object>  paramData) throws IOException {
		SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			String paramDataJsonString=objectMapper.writeValueAsString(paramData);
			
		try {
				paramDataJsonString=AES.Encrypt(paramDataJsonString, "1234567890abcDEF");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			HttpGet httpget = new HttpGet(REQUEST_URL+serviceCode+"&paramData="+paramDataJsonString);

			System.out.println("Executing request " + httpget.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						System.out.println(entity.toString());
						return entity != null ? EntityUtils.toString(entity)
								: null;
						
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
			Map<String,Object> data=new HashMap<String, Object>();
			System.out.println("接收到请求时间"+sdf.format(new Date()));
			data=objectMapper.readValue(responseBody, Map.class);
			String dataStr=data.get("data").toString();
			System.out.println("解析出请求时间"+sdf.format(new Date()));
			System.out.println(AES.Decrypt(dataStr, "1234567890abcDEF"));
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			httpclient.close();
		}
	}
	@SuppressWarnings("unchecked")
	public static Map<String,Object> sendPostRetureMap(String serviceCode,Map<String,Object>  paramData ,Class<?> returnDataType) throws IOException {
		SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			
			String paramDataJsonString=objectMapper.writeValueAsString(paramData);
			
			try {
				paramDataJsonString=AES.Encrypt(paramDataJsonString, "1234567890abcDEF");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			HttpGet httpget = new HttpGet(REQUEST_URL+serviceCode+"?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123&paramData="+paramDataJsonString);
			
			System.out.println("Executing request " + httpget.getRequestLine());
			
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				
				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						System.out.println(entity.toString() +" -----------");
						return entity != null ? EntityUtils.toString(entity)
								: null;
						
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}
				
			};
			String responseBody = httpclient.execute(httpget, responseHandler);//get yikangservice
			Map<String,Object> data=new HashMap<String, Object>();
			System.out.println("接收到请求时间"+sdf.format(new Date()));
			data=objectMapper.readValue(responseBody, Map.class);
			if(data.containsKey("data") && null != data.get("data")){
				String dataStr=data.get("data").toString();
				sendRequestLogger.info("解析出请求时间"+sdf.format(new Date()));
				String returnDataStr=AES.Decrypt(dataStr, "1234567890abcDEF");
				sendRequestLogger.debug(returnDataStr);
				System.out.println(returnDataStr);
				Object returnData=objectMapper.readValue(returnDataStr, returnDataType);
				data.put("data", returnData);
			}

			return data;
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			httpclient.close();
		}
		return null;
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static ResponseMessage sendPostRetureResponseMessage(String serviceCode,Map<String,Object>  paramData ,Class t) throws IOException {
		SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			
			String paramDataJsonString=objectMapper.writeValueAsString(paramData);
			
			try {
				paramDataJsonString=AES.Encrypt(paramDataJsonString, "1234567890abcDEF");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			HttpGet httpget = new HttpGet(REQUEST_URL+serviceCode+"?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123&paramData="+paramDataJsonString);
			
			System.out.println("Executing request " + httpget.getRequestLine());
			
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				
				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						sendRequestLogger.info(entity.toString());
						return entity != null ? EntityUtils.toString(entity)
								: null;
						
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}
				
			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			
			
			ResponseMessage responseMessage =new ResponseMessage();
			
			System.out.println("接收到请求时间"+sdf.format(new Date()));
			responseMessage=objectMapper.readValue(responseBody, responseMessage.getClass());
			if(null != responseMessage.getData()){
				String dataStr=responseMessage.getData().toString();
				System.out.println("解析出请求时间"+sdf.format(new Date()));
				String returnDataStr=AES.Decrypt(dataStr, "1234567890abcDEF");
				sendRequestLogger.debug(returnDataStr);
				System.out.println(returnDataStr);
				Object returnData=objectMapper.readValue(returnDataStr, t);
				responseMessage.setData(returnData);
				
			}

			return responseMessage;
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			httpclient.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println((int)'y');
	}

}
