package com.service;

import java.util.List;

import com.dto.LabAppStat;

public interface InfoStatService {
	public List<LabAppStat> LabAppStat(String value);
	public List<String> InfoStat();
	
}
