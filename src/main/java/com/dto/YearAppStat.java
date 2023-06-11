package com.dto;

public class YearAppStat {
	private String years;
	private Integer counts;
	
	public YearAppStat(String years,Integer counts) {
		this.years = years;
		this.counts = counts;
	}
	
	
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
	
	
	
}
