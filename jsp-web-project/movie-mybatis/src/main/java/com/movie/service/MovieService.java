package com.movie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.movie.model.MovieDTO;

public interface MovieService {
	// 영화 추가
	void addMovie(HttpServletRequest req) throws Exception;

	// 영화 리스트 출력
	List<MovieDTO> getAllMovies() throws Exception;

	// 개별 영화 가져오기
	MovieDTO getMovie(HttpServletRequest req) throws Exception;

	// 영화 삭제
	void deleteMovie(HttpServletRequest req) throws Exception;

	// 영화 수정
	void updateMovie(HttpServletRequest req) throws Exception;
}
