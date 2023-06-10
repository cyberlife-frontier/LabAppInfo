package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.LabAppStat;
import com.util.JDBCUtil;
import com.dao.InfoStatDao;

public class InfoStatDaoImpl implements InfoStatDao{

	@Override
	public List<LabAppStat> LabAppStat(String value) {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "select app_name, count(app_name) as counts from appliance_info "
				+ "where lab_num= '"+value+"' group by app_name ";
		PreparedStatement statement = null;
		ResultSet resultset =null;
		List<LabAppStat> LabAppStat = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);  
			resultset = statement.executeQuery();
			while(resultset.next()) {
				String app_name = resultset.getString(1);
				Integer counts = resultset.getInt(2);
				LabAppStat.add(new LabAppStat(app_name,counts));
			}
			
		}catch(SQLException throwables) {
			
		}finally {
			JDBCUtil.closeDB(connection, statement, resultset);
		}

		return LabAppStat;
	}

	@Override
	public List<String> InfoStat() {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "select distinct lab_num from appliance_info";
		PreparedStatement statement = null;
		ResultSet resultset =null;
		List<String> InfoStat = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);  
			resultset = statement.executeQuery();
			while(resultset.next()) {
				InfoStat.add(resultset.getString(1));
	
			}
			
		}catch(SQLException throwables) {
			
		}finally {
			JDBCUtil.closeDB(connection, statement, resultset);
		}

		return InfoStat;
	}

}
