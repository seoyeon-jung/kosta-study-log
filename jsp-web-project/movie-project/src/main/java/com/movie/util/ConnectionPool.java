package com.movie.util;

import java.sql.Connection;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

// db와의 연결을 관리
public class ConnectionPool {
	public static class DBPool {
		private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		private static final String DB_URL = "jdbc:mysql://localhost:3306/movie_db";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD = "1234";

		static final BasicDataSource dbcp = new BasicDataSource();

		static {
			dbcp.setDriverClassName(JDBC_DRIVER);
			dbcp.setUrl(DB_URL);
			dbcp.setUsername(DB_USER);
			dbcp.setPassword(DB_PASSWORD);
		}

		public static Connection getDBPool() throws Exception {
			return dbcp.getConnection();
		}
	}
}