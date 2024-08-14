package com.movie.mapper;

import java.util.List;

import com.movie.dto.MovieDTO;

public interface MovieMapper {

	List<MovieDTO> selectAllmovies() throws Exception;

}
