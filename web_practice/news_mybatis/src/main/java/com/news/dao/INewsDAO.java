package com.news.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.news.config.SQLSessionFactory;
import com.news.model.NewsDTO;

public class INewsDAO implements NewsDAO {
	private SqlSessionFactory ssf = SQLSessionFactory.getSsf();

	@Override
	public List<NewsDTO> getAllMewsList() throws Exception {
		// openSession(true) 는 자동 커밋을 진행
		// oepnSession() 또는 openSession(faose)는 수동 커밋을 진행 (이전으로 되돌리는 rollback도 가능)
		SqlSession sqlSession = ssf.openSession();
		List<NewsDTO> newsList = sqlSession.selectList("selectNewsAll");
		sqlSession.close();
		return newsList;
	}

	@Override
	public void insertNews(NewsDTO news) throws Exception {

	}

	@Override
	public void getNewsById(int id) throws Exception {

	}

	@Override
	public void deleteNewsById(int id) throws Exception {

	}

	@Override
	public void updateNews(int id) throws Exception {

	}

}
