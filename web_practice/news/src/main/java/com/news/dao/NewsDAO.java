package com.news.dao;

import java.util.List;

import com.news.model.News;

public interface NewsDAO {
	// 뉴스 기사 추가
	void addNews(News news) throws Exception;

	// 뉴스 기사 전체보기
	List<News> getAll() throws Exception;

	// 뉴스 기사 보기
	News getNews(int id) throws Exception;

	// 뉴스 기사 삭제
	void deleteNews(int id) throws Exception;
}
