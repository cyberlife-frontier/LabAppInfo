package com.entity;

public class ApplianceInfo {
	private String app_num ; 
	private String app_name ;
	private String lab_num ;
	private String date_purchase ;
	private String app_admin;
	
	
	public ApplianceInfo(String app_num,String app_name,
			String lab_num,String date_purchase,String app_admin) {
		this.app_num = app_num;
		this.app_name = app_name;
		this.lab_num = lab_num;
		this.date_purchase = date_purchase;
		this.app_admin = app_admin;
	}
	
	public String getApp_num() {
		return app_num;
	}
	public void setApp_num(String app_num) {
		this.app_num = app_num;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public String getLab_num() {
		return lab_num;
	}
	public void setLab_num(String lab_num) {
		this.lab_num = lab_num;
	}
	public String getDate_purchase() {
		return date_purchase;
	}
	public void setDate_purchase(String date_purchase) {
		this.date_purchase = date_purchase;
	}

	public String getApp_admin() {
		return app_admin;
	}

	public void setApp_admin(String app_admin) {
		this.app_admin = app_admin;
	}
	
}
