package com.dto;

public class LabAppStat {
	
	private String app_name ;
	private Integer counts;
	
	public LabAppStat(String app_name,Integer counts) {
		
		this.app_name = app_name;
		this.counts = counts;
	}
	
	
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
}
