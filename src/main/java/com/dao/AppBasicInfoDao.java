package com.dao;

import java.util.List;

import com.entity.ApplianceInfo;

public interface AppBasicInfoDao {
	public List<ApplianceInfo> ApplianceInfo(); 
	public List<ApplianceInfo> InfoQuery(String key,String value);
	public List<String> InfoStat();
	public List<String> PersonnelAdmin();
	public Integer addInfo(String app_num,String app_name,String lab_num,
			String date_purchase,String app_admin);
	public Integer delInfo(String app_num);
	public List<String> showAppPic(String app_num);
	public Integer addAppPic(String app_num,String DBsave);
}
