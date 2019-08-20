package net.lgs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectMySQL {

	// 10.88.222.142(root,root)
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&useServerPrepStmts=false&rewriteBatchedStatements=true";
	private static final String NAME = "root";
	private static final String PASSWORD = "qwerty";

	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;

	public static void init() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
			System.out.println("MySQL is connected.");
		} catch (SQLException e) {
			System.out.println("MySQL connection failed.");
			e.printStackTrace();
		}
	}

	public static int addUpdDel(String sql) {
		int rows = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			rows = pst.executeUpdate();
			System.out.println("MySQL add/delete/update is completed.");
		} catch (SQLException e) {
			System.out.println("MySQL add/delete/update failed.");
			e.printStackTrace();
		}
		return rows;
	}

	public static ResultSet selectSql(String sql) {
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			System.out.println("MySQL query is completed.");
		} catch (SQLException e) {
			System.out.println("MySQL query failed.");
			e.printStackTrace();
		}
		return rs;
	}

	public static void closeConn() {
		try {
			conn.close();
			System.out.println("MySQL connection is closed.");
		} catch (SQLException e) {
			System.out.println("MySQL connection closed failed.");
			e.printStackTrace();
			conn = null;
		}
	}

}
