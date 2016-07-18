package com.yikangyiliao.pension.common.cache;

import java.net.URL;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCache {
	
//	@Resource(name="redisTemplate")
//	private ListOperations<String, String> listOps;

//	@Resource(name="redisTemplate")
//	private RedisTemplate<String, String> redisTemplate;
	
	
//	@Resource(name="stringRedisTemplate")
//	private StringRedisTemplate stringRedisTemplate; 
//	


//	public void addLink(String userId, URL url) {
//	  listOps.leftPush(userId, url.toExternalForm());
//	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/25 14:52
	 * 添加请求链接
	 * */
//	public void addLink(String userId, URL url) {
//		stringRedisTemplate.opsForList().leftPush(userId, url.toExternalForm());
//	}
	
	/***
	 * @author liushuaic
	 * @date 2015/11/25 12:06
	 * 存储字符串
	 * **/
//	public void putStringKeyStringVal(String key,String val){
//		redisTemplate.opsForValue().set(key, val);
//		return redisTemplate.opsForList().leftPush(key, val);
//	}
	
	/**
	 * @author liushuaic
	 * @date 2015/11/25 14:08
	 * 获取字符串
	 * 
	 * **/
//	public String getStringByStringKey(String key){
//		return	redisTemplate.opsForValue().get(key);
//		return redisTemplate.opsForList().rightPopAndLeftPush(key, key);
//	}
}
