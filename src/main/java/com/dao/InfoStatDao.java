package com.dao;

import java.util.List;

import com.dto.LabAppStat;

public interface InfoStatDao {
	public List<LabAppStat> LabAppStat(String value);
	public List<String> InfoStat();
	
}
