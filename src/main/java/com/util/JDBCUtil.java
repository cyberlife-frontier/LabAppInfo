package com.util;
import java.sql.*;

public class JDBCUtil {
	private static String driverName ="com.mysql.cj.jdbc.Driver";   //驱动程序名
	private static String userName = "root";                      //数据库用户名
	private static String userPwd = "root";                     //密码
	private static String dbName = "lab_app_info";                    //数据库名
	public static Connection getDBconnection() {
		String  url1="jdbc:mysql://localhost:3306/"+dbName;
		String  url2 ="?user="+userName+"&password="+userPwd;
		String  url3="&useUnicode=true&characterEncoding=GB2312";
		String  url =url1+url2+url3;
		try {
			Class.forName(driverName);		
			Connection con=DriverManager.getConnection(url); 
			return con;
			}catch (Exception e) {
				e.printStackTrace();
				}
		return null;
		}	   
	public static void closeDB(Connection con,PreparedStatement  pstm, ResultSet rs){
		try {
			if(rs!=null) rs.close(); 
 		    if(pstm!=null) pstm.close();
 		    if(con!=null) con.close();
 		    }catch (SQLException e) {
 		    	e.printStackTrace();			
			}
	   }
		
		/*
		 * public static void main(String[] args) {
		 * System.out.println(JDBCUtil.getDBconnection()); }
		 */
		 
}
