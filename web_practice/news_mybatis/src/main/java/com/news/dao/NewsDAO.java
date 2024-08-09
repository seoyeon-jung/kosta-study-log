package com.news.dao;

import java.util.List;

import com.news.model.NewsDTO;

public interface NewsDAO {
	// 뉴스 기사 전체 보기
	List<NewsDTO> getAllMewsList() throws Exception;

	// 뉴스 기사 추가
	void insertNews(NewsDTO news) throws Exception;

	// 뉴스 기사 보기
	void getNewsById(int id) throws Exception;

	// 뉴스 기사 삭제
	void deleteNewsById(int id) throws Exception;

	// 뉴스 기사 수정
	void updateNews(int id) throws Exception;
}
