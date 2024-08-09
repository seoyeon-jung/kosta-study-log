package com.news.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SQLSessionFactory {
	// DB에 SQL 명령 실행 메소드를 가진 객체 (SqlSessionFactory)
	public static SqlSessionFactory ssf;

	static {
		// 설정 파일 경로
		String resource = "com/news/config/mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			ssf = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			System.err.println("SQL 설정 에러 : " + e);
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSsf() {
		return ssf;
	}
}
