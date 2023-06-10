package com.service.impl;

import java.util.List;

import com.service.InfoStatService;
import com.dto.LabAppStat;
import com.dao.InfoStatDao;
import com.dao.impl.InfoStatDaoImpl;


public class InfoStatServiceImpl implements InfoStatService{
	private InfoStatDao InfoStatDao = new InfoStatDaoImpl();
	
	@Override
	public List<LabAppStat> LabAppStat(String value) {
		// TODO 自动生成的方法存根
		
		return this.InfoStatDao.LabAppStat(value);
	}

	@Override
	public List<String> InfoStat() {
		// TODO 自动生成的方法存根
		return this.InfoStatDao.InfoStat();
	}

}
