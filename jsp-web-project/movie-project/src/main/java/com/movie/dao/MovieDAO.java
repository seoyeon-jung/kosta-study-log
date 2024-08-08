package com.movie.dao;

import java.util.List;

import com.movie.model.Movie;

public interface MovieDAO {
	// 영화 추가
	void addMovie(Movie movie) throws Exception;

	// 영화 리스트 출력
	List<Movie> getAllMovies() throws Exception;

	// 개별 영화 가져오기
	Movie getMovie(int id) throws Exception;

	// 영화 삭제
	void deleteMovie(int id) throws Exception;

	// 영화 수정
	void updateMovie(Movie movie) throws Exception;
}
