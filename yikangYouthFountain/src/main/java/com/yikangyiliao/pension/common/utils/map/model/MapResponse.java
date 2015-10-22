package com.yikangyiliao.pension.common.utils.map.model;

import java.util.List;

public class MapResponse<T> {
	
	
	private String status;
	
	private String info;
	
	private List<T> results;

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

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
	
	

}
