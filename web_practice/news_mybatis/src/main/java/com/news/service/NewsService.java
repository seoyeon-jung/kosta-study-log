package com.news.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.news.model.NewsDTO;

public interface NewService {
	// 뉴스 기사 전체 보기
	List<NewsDTO> getAll() throws Exception;

	// 뉴스 기사 추가
	void addNews(HttpServletRequest req) throws Exception;

	// 뉴스 기사 보기
	void getNews(HttpServletRequest req) throws Exception;

	// 뉴스 기사 삭제
	void removeNews(HttpServletRequest req) throws Exception;

	// 뉴스 기사 수정
	void editNews(HttpServletRequest req) throws Exception;
}
