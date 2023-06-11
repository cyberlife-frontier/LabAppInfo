package com.service;

import java.util.List;

import com.dto.LabAppStat;
import com.dto.YearAppStat;

public interface InfoStatService {
	public List<LabAppStat> LabAppStat(String value);
	public List<String> InfoStat();
	public List<YearAppStat> YearAppStat();
	
}
