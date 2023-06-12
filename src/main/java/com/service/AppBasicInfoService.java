package com.service;

import java.util.List;

import com.entity.ApplianceInfo;

public interface AppBasicInfoService {
	public List<ApplianceInfo> ApplianceInfo();
	public List<ApplianceInfo> InfoQuery(String key,String value);
	public List<String> InfoStat();
	public List<String> PersonnelAdmin();
	public void addInfo(String app_num,String app_name,String lab_num,
			String date_purchase,String str[]);
	public void delInfo(String app_num);
	public List<String> showAppPic(String app_num);
}
