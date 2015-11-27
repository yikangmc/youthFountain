package com.yikangyiliao.pension.common.utils.map.model.assistant;

import java.util.LinkedHashMap;
import java.util.List;

public class MapResponseAssistant {
	
	private String status;
	
	private String info;
	
	private List<LinkedHashMap<String, Object>> tips;
	
	private Long count;

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<LinkedHashMap<String, Object>> getTips() {
		return tips;
	}

	public void setTips(List<LinkedHashMap<String, Object>> tips) {
		this.tips = tips;
	}
	
	
}
