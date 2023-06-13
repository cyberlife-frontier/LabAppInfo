package com.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.entity.ApplianceInfo;
import com.service.AppBasicInfoService;

import jakarta.servlet.http.Part;

import org.apache.commons.lang.RandomStringUtils;

import com.dao.AppBasicInfoDao;
import com.dao.impl.AppBasicInfoDaoImpl;

public class AppBasicInfoServiceImpl implements AppBasicInfoService{
	private AppBasicInfoDao AppBasicInfoDao = new AppBasicInfoDaoImpl();
	private String uploadPath = "D:/Users/Nash/Documents/eclipse-workspace/LabAppInfo/webcontent/Assets/images/";
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
	@Override
	
	public void addAppPic(String app_num, Collection<Part> parts) {
		// TODO 自动生成的方法存根
		
		Integer code = 0;
		String DBsave = "Assets/images/";
		List<String> arr_DBsave= new ArrayList<>();
		String name = "";
		String ex_name ="";
		
		try {	 
			 for (final Part part : parts) {
				 String FileName = part.getSubmittedFileName();

				 if(FileName != null) {
				
				 name =RandomStringUtils.randomAlphanumeric(10);
 
			     part.write(uploadPath+part.getSubmittedFileName());
				 }//if
			}//for
		}catch(Exception e) {
			throw new RuntimeException("仪器图片添加失败");
		}//catch

		code = this.AppBasicInfoDao.addAppPic(app_num, DBsave);
		if(code !=1 ) throw new RuntimeException("仪器图片添加失败");
	}

}//class AppBasicInfoServiceImpl
