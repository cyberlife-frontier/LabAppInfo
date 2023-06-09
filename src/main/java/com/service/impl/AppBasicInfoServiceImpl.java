package com.service.impl;

import java.util.List;

import com.entity.ApplianceInfo;
import com.service.AppBasicInfoService;
import com.dao.AppBasicInfoDao;
import com.dao.impl.AppBasicInfoDaoImpl;

public class AppBasicInfoServiceImpl implements AppBasicInfoService{
	private AppBasicInfoDao AppBasicInfoDao = new AppBasicInfoDaoImpl();
	@Override
	public List<ApplianceInfo> ApplianceInfo() {
		// TODO 自动生成的方法存根
	
		return this.AppBasicInfoDao.ApplianceInfo();
	}

}
