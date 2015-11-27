package com.yikangyiliao.pension.common.utils.map;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.yikangyiliao.pension.common.utils.map.model.GeoCodeModel;
import com.yikangyiliao.pension.common.utils.map.model.MapResponse;
import com.yikangyiliao.pension.common.utils.map.model.assistant.MapResponseAssistant;

/**
 * @author liushuaic
 * @date 2015/10/15 12:27
 * @desc 地图位置 工具类
 * */
public class MapUtils {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static String requestURl="http://restapi.amap.com/v3/";
	
	private static String KEYPARAM="key=062c151bbabb1e99cb6a45621c29b6d7";
	
	/**
	 * @author liushuaic
	 * @throws IOException 
	 * @date 2015/10/15 13:58
	 * @desc 获取经纬度，根据地址
	 * @param address 省+市+区+街道+门牌号
	 * @param city 北京/beijing/010/110000
	 * @param output json,xml
	 * @return GeoCodeModel
	 * 
	 * */
	public static GeoCodeModel getGeoCodeModelByAddress(String address,String city) throws IOException{
		
		String paramStr=KEYPARAM+"";
		if(null != address && address !=""){
			
			paramStr=paramStr+"&address='"+URLEncoder.encode(address)+"'";
		}
		if(null != city && city !=""){
			paramStr=paramStr+"&city='"+city+"'";
		}
		
		
		GeoCodeModel geoCodeModel=null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			
			String url=requestURl+"geocode/geo?"+paramStr;
			//System.out.println(url);
			HttpGet httpget = new HttpGet(url);

			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
						
					} else {
						throw new ClientProtocolException( "Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			//System.out.println(responseBody);
			if(null != responseBody){
				geoCodeModel=objectMapper.readValue(responseBody.getBytes(), GeoCodeModel.class);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			httpclient.close();
		} 
		
		
		return geoCodeModel;
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/21 10:43
	 * 查询出发地与目的地，之间的行驶距离，及预计行驶时间
	 * 
	 * @param origins {(1.33333,0.333444),(1.444444,0.66666)}
	 * @param distance 1.3333,0.666666
	 * @throws IOException 
	 * 
	 * ***/
	public static MapResponse<LinkedHashMap<String,String>> getOriginsDestinationDistance(String[] origins,String destination) throws IOException{
		
		String  orginsStr="";
		if(null != origins){
		
			for(int i=0;i<origins.length;i++){
				orginsStr=orginsStr+origins[i];
				if(i<(origins.length-1)){
					orginsStr=orginsStr+"%7C";
				}
			}
		}
	
		
		String paramStr=KEYPARAM+"";
		if(!orginsStr.equals("") ){
			paramStr=paramStr+"&origins="+orginsStr;
		}
		
		if(null != destination && destination !=""){
			paramStr=paramStr+"&destination="+destination;
		}
		
		
		MapResponse<LinkedHashMap<String,String>> distances=null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			
			String url=requestURl+"distance?"+paramStr;
			//System.out.println(url);
			
			
			HttpGet httpget = new HttpGet(url);

			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException( "Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			if(null != responseBody){
				distances=objectMapper.readValue(responseBody.getBytes(), MapResponse.class);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			httpclient.close();
		} 
		
		
		return distances;
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/22 10:59
	 * @desc 获取地址经纬度
	 **/
	public static String getAddressPosition(String mapPositionAddress,String detailAddress,String cityCode){
		
		if(mapPositionAddress.length()>0){
			 try {
				 GeoCodeModel geoCodeModel=MapUtils.getGeoCodeModelByAddress(mapPositionAddress+detailAddress,cityCode);
				 if(null != geoCodeModel && null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
					 //  TODO 有可能模糊地址对应的有多个这个问题要修改
					 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
					
					 return lngLatStr;
				 }else{
					 geoCodeModel=MapUtils.getGeoCodeModelByAddress(mapPositionAddress, cityCode);
					 if(null != geoCodeModel && null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
						 //  TODO 有可能模糊地址对应的有多个这个问题要修改
						 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
						
						 return lngLatStr;
					 }
				 }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "";
	}
	
	
	
	/**
	 * @author liushuaic
	 * @throws IOException 
	 * @date 2015/11/09 18:54
	 * @desc 获取相关词
	 * **/
	public static MapResponseAssistant getAssistantInputtips(String keywords,String location,String city) throws IOException{
		
	
		
		String paramStr=KEYPARAM+"";
		if(!keywords.equals("") ){
			paramStr=paramStr+"&keywords="+keywords;
		}
		
		if(null != location && location !=""){
			paramStr=paramStr+"&location="+location;
		}
		
		if(null != city && city !=""){
			paramStr=paramStr+"&city="+city;
		}
		
		
		
		MapResponseAssistant distances=new MapResponseAssistant();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			
			String url=requestURl+"assistant/inputtips?"+paramStr;
			
			HttpGet httpget = new HttpGet(url);

			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException( "Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			if(null != responseBody){
				distances=objectMapper.readValue(responseBody.getBytes(), distances.getClass());
				return distances;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			httpclient.close();
		} 
		
		return distances;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
//		GeoCodeModel gmc=MapUtils.getGeoCodeModelByAddress("five plus旗舰店",null);
//		System.out.println(gmc.getGeocodes().get(0).getLocation());
//		MapUtils.getOriginsDestinationDistance();
//		System.out.println(gmc.getGeocodes().get(0).getLocation());
		
//		String[] origins={"116.427944,39.903409","116.449226,39.854431"};
//		String destination="116.39241,39.896297";
//		 MapResponse<LinkedHashMap<String,String>> data=MapUtils.getOriginsDestinationDistance(origins, destination);
//		 System.out.println(data.getResults().get(0).get("distance"));
		
//		System.out.println(URLEncoder.encode("北京市海淀区万寿路(光华护士基金@@)"));
//		System.out.println(URLEncoder.encode("|"));
		
		
		MapResponseAssistant ass=MapUtils.getAssistantInputtips("光华",  null,"北京");
		for(LinkedHashMap<String,Object> data:ass.getTips()){
			System.out.println(data.get("name"));
		}
	}
	
}
