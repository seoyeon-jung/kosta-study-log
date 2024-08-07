package com.news.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

// ConnectionPool : DB와의 연결을 관리하는 도구
// 여러 개의 연결을 미리 만들어놓고 필요할 때마다 제공해준다.
public class ConnetionPool {

	// DB와의 연결
	public static class DBPool {
		private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		private static final String DB_URL = "jdbc:mysql://localhost:3306/news_db";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD = "1234";

		// apache에 DBCP(DataBase Connection Pooling) 라이브러리에서 제공하는 클래스를 사용
		static final BasicDataSource dbcp = new BasicDataSource();

		static {
			dbcp.setDriverClassName(JDBC_DRIVER);
			dbcp.setUrl(DB_URL);
			dbcp.setUsername(DB_USER);
			dbcp.setPassword(DB_PASSWORD);

			// 연결 수 관리
			dbcp.setInitialSize(10); // 초기 연결수를 10개로 설정
			dbcp.setMaxTotal(50); // 최대 연결 수 50개로 설정
			dbcp.setMaxIdle(20); // 최대 유효 연결 수 20개로 설정
			dbcp.setMinIdle(5); // 최소 유효 연결 수 5개로 설정
		}

		// 연결 가져오기
		public static Connection getDBPool() throws SQLException {
			return dbcp.getConnection();
		}
	}
}
