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

	@Override
	public List<ApplianceInfo> InfoQuery(String key, String value) {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "";
		switch(key) {
		case "app_name":
			sql = "select * from appliance_info where "+ key + " like '%"+ value +"%'";
			break;
		case "app_num":
			sql = "select * from appliance_info where "+ key + " = '"+ value +"'" ;
			break;
		}
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

	@Override
	public List<String> InfoStat() {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "select lab_num from lab_info";
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

	@Override
	public List<String> PersonnelAdmin() {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "select admin_name from personnel_admin";
		PreparedStatement statement = null;
		ResultSet resultset =null;
		List<String> PersonnelAdmin = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);  
			resultset = statement.executeQuery();
			while(resultset.next()) {
				PersonnelAdmin.add(resultset.getString(1));
	
			}
			
		}catch(SQLException throwables) {
			
		}finally {
			JDBCUtil.closeDB(connection, statement, resultset);
		}

		return PersonnelAdmin;
	}

	@Override
	public Integer addInfo(String app_num, String app_name, String lab_num, 
			String date_purchase, String app_admin) {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "insert into appliance_info(app_num,app_name,lab_num,"
				+ "date_purchase,app_admin) value(?,?,?,?,?)";
		PreparedStatement statement = null;
		Integer result = null;
		try {
			statement = connection.prepareStatement(sql);  
			statement.setString(1, app_num);
			statement.setString(2, app_name);
			statement.setString(3, lab_num);
			statement.setString(4, date_purchase);
			statement.setString(5, app_admin);
			
			result = statement.executeUpdate();
			
			
		}catch(SQLException throwables) {
			
		}finally {
			JDBCUtil.closeDB(connection, statement, null);
		}
		return result;
	}

	@Override
	public Integer delInfo(String app_num) {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "delete from appliance_info where app_num = ?";
		PreparedStatement statement = null;
		Integer result = null;
		try {
			statement = connection.prepareStatement(sql);  
			statement.setString(1, app_num);
			result = statement.executeUpdate();

		}catch(SQLException throwables) {
			
		}finally {
			JDBCUtil.closeDB(connection, statement, null);
		}
		return result;
	}

	@Override
	public List<String> showAppPic(String app_num) {
		// TODO 自动生成的方法存根
		Connection connection = JDBCUtil.getDBconnection();
		String sql = "select app_pic from appliance_pic"
				+ " where app_num = '"+app_num+"'";
		PreparedStatement statement = null;
		ResultSet resultset =null;
		List<String> showAppPic = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);  
			resultset = statement.executeQuery();
			while(resultset.next()) {
				showAppPic.add(resultset.getString(1));
	
			}
			
		}catch(SQLException throwables) {
			
		}finally {
			JDBCUtil.closeDB(connection, statement, resultset);
		}

		return showAppPic;
	}

	@Override
	public Integer addAppPic(String app_num, String DBsave) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	
	
}
