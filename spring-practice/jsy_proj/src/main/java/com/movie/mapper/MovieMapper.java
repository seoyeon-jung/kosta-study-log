package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movie.dto.MovieDTO;

@Mapper
public interface MovieMapper {
	// 영화 리스트 가져오기
	List<MovieDTO> selectAllmovies() throws Exception;

	// 영화 추가
	void insertMovie(MovieDTO movieDTO);

	// 영화 하나 가져오기
	MovieDTO selectMovieById(int id) throws Exception;

	// 영화 삭제
	void deleteMovieById(int id) throws Exception;

	// 영화 수정
	void updateMovie(MovieDTO movieDTO) throws Exception;

}
