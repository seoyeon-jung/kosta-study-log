package com.news.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.news.model.News;

public interface NewsService {

	// 뉴스 기사 추가
	void addNews(HttpServletRequest req) throws Exception;

	// 뉴스 기사 전체보기
	List<News> getAll() throws Exception;

	// 뉴스 기사 보기
	News getNews(HttpServletRequest req) throws Exception;

	// 뉴스 기사 삭제
	void deleteNews(HttpServletRequest req) throws Exception;

	// 뉴스 기사 수정
	void moodifyNews(HttpServletRequest req) throws Exception;
}

// controller 에서 기사 추가를 하면 request 안에 기사 추가하는 내용드링 잇다
// 이걸 getParameters에서 받아와서 뿌려주는 건 너무 길어진다
// req 값만 전달해주면 service 안에서 dao로 넘겨서 만들 수 있다.