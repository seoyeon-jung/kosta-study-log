package com.kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;

// DB 연결
public class DBConnection {
	public static final String DB = "kostagram";
	public static final String URL = "jdbc:mysql://localhost:3306/" + DB;
	public static final String USER = "root";
	public static final String PASSWORD = "1234";

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}

	// TODO 리소스 해제 메소드
}
