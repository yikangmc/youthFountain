package com.yikangyiliao.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author liushuaic
 * @date 2015/07/29 15:24
 * @desc 日期工具类
 * **/
public class DateUtils {
	
	
	
	/**
	 * @param dataStr 2015-06-25
	 * @return  毫秒
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/07/29 15:42
	 * 列2015-10-10 获取的毫秒数为 2015-10-10 00:00:00
	 * ***/
	public static Long getＭillisecond(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr).getTime();
	}
	
	/**
	 * @param dataStr 2015-06-25
	 * @return  毫秒
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/07/29 15:42
	 * 列2015-10-10 获取的毫秒数为 2015-10-10 00:00:00
	 * ***/
	public static Date getDate(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/15 11:37
	 * @desc 获取当前日期的格式化的，字符串
	 * @return '20151015'
	 * 
	 * */
	public static String getFormateCurrenteDateStr(){
		
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyyMMdd");
		
		return sdf3.format(Calendar.getInstance().getTime());
	}
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=sdf.parse("2015-07-15");
		System.out.println(d.getTime());
		System.out.println(sdf2.format(sdf.parse("2015-07-15")));
		
		
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyyMMdd");
		System.out.println(sdf3.format(Calendar.getInstance().getTime()));
		
	}

}
