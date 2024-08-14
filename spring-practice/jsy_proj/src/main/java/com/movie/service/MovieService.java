package com.movie.service;

import java.util.List;

import com.movie.dto.FileDTO;
import com.movie.dto.MovieDTO;

public interface MovieService {
	// 영화 리스트 보여주기
	List<MovieDTO> getAllMovies() throws Exception;

	// 영화 정보 작성
	void postMovie(MovieDTO movie) throws Exception;

	// 영화 정보 상세보기
	MovieDTO getMovieById() throws Exception;

	// 영화 정보 삭제
	void deleteMovie(int id) throws Exception;

	// 영화 정보 수정
	void updateMovie(MovieDTO movieDTO) throws Exception;

	// 영화 관련 이미지 다운로드
	FileDTO selectFileById(int id, int movieId) throws Exception;

}
