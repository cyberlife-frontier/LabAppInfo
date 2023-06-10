package com.service;

import java.util.List;

import com.entity.ApplianceInfo;

public interface AppBasicInfoService {
	public List<ApplianceInfo> ApplianceInfo();
	public List<ApplianceInfo> InfoQuery(String key,String value);
	public List<String> InfoStat();
	
}
