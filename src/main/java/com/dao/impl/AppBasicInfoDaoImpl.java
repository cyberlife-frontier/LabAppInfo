package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ApplianceInfo;
import com.util.JDBCUtil;
import com.dao.AppBasicInfoDao;

public class AppBasicInfoDaoImpl implements  AppBasicInfoDao{

	@Override
	public List<ApplianceInfo> ApplianceInfo() {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "select * from appliance_info ";
		PreparedStatement statement = null;
		ResultSet resultset =null;
		List<ApplianceInfo> ApplianceInfo =  new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);  
			resultset = statement.executeQuery();
			while(resultset.next()) {
				String app_num = resultset.getString(1);
				String app_name = resultset.getString(2);
				String lab_num = resultset.getString(3);
				String date_purchase = resultset.getString(4);
				String app_admin = resultset.getString(5);
				ApplianceInfo.add(new ApplianceInfo(app_num,app_name,
						lab_num,date_purchase,app_admin));
				
			}
			
		}catch(SQLException throwables) {
			
		}finally {
			JDBCUtil.closeDB(connection, statement, resultset);
		}

		return ApplianceInfo;
	}
	
	
	
}
