package com.yikangyiliao.pension.common.utils.map.model;



/**
 * 
 * @author liushuaic
 * @date 2015/10/21 10:55
 * @desc 距离
 * 
 * **/
public class DistanceModal {
	
	/**
	 * 出发标识
	 * */
	private String origin_id;
	
	/**
	 * 目的地标识
	 * */
	private String dest_id;
	
	/**
	 * 距离
	 * **/
	private String distance;
	
	/**
	 * 预计行驶时间
	 * **/
	private String duration;
	
	

	

	public String getOrigin_id() {
		return origin_id;
	}

	public void setOrigin_id(String origin_id) {
		this.origin_id = origin_id;
	}

	public String getDest_id() {
		return dest_id;
	}

	public void setDest_id(String dest_id) {
		this.dest_id = dest_id;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
