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
	@Override
	public List<ApplianceInfo> InfoQuery(String key, String value) {
		// TODO 自动生成的方法存根
		if(value.equals(""))
			return this.AppBasicInfoDao.ApplianceInfo();
		
		return this.AppBasicInfoDao.InfoQuery(key, value);
	}
	@Override
	public List<String> InfoStat() {
		// TODO 自动生成的方法存根
		return this.AppBasicInfoDao.InfoStat();
	}
	@Override
	public List<String> PersonnelAdmin() {
		// TODO 自动生成的方法存根
		return this.AppBasicInfoDao.PersonnelAdmin();
	}
	@Override
	public void addInfo(String app_num, String app_name, String lab_num,
			String date_purchase, String[] str) {
		// TODO 自动生成的方法存根
		Integer i =1;
		String app_admin = "";
		app_admin = app_admin +str[0];
		while(i < str.length) {
			app_admin = app_admin +" "+str[i];
			i++;
		}
		Integer code = this.AppBasicInfoDao.addInfo(app_num, app_name, lab_num,
				date_purchase, app_admin);
		if(code != 1) throw new RuntimeException("仪器基本信息添加失败");
		
	}
	@Override
	public void delInfo(String app_num) {
		// TODO 自动生成的方法存根
		Integer code = this.AppBasicInfoDao.delInfo(app_num);
		if(code != 1) throw new RuntimeException("仪器基本信息删除失败");
		
	}
	@Override
	public List<String> showAppPic(String app_num) {
		// TODO 自动生成的方法存根
		return this.AppBasicInfoDao.showAppPic(app_num);
	}

}
