package com.tocean.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * 工具类
 * 
 * @author Administrator
 *
 */


public class JdbcUtils {
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/booksys";
	private static String user = "root";
	private static String password = "123456";

	static {
		try {
			Class.forName(driverClass);// 加载驱动类
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Statement
	 * 
	 * @param rs
	 */
	public static void close(Statement stmt) {
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Connection
	 * 
	 * @param rs
	 */
	public static void close(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭资源
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		close(rs);
		close(stmt);
		close(conn);
	}

	/**
	 * 执行insert,update,delete等操作
	 * 
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int executeUpdate( Connection conn ,
			String sql, Object[] params)
			throws SQLException {
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			if (null != params && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			int count = stmt.executeUpdate();
			return count;
		} finally {
			close(stmt);
		}
	}
	
	/**
	 * 查询，执行select语句
	 * @param conn
	 * @param sql
	 * @param params
	 * @param handler
	 * @return
	 * @throws SQLException
	 */
	public  static <T> List<T> executeQuery(Connection conn, 
			String sql,Object[] params,
			ResultSetHandler<T> handler ) 
			throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			stmt = conn.prepareStatement(sql);
			if (null != params && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				T o = handler.getEntity(rs);
				list.add(o);
			}
			return list;
		} finally {
			close(rs,stmt,null);
		}
	}
}
