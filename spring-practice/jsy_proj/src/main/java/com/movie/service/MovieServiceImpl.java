package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.FileDTO;
import com.movie.dto.MovieDTO;
import com.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieMapper movieMapper;

	@Override
	public List<MovieDTO> getAllMovies() throws Exception {
		return movieMapper.selectAllmovies();
	}

	@Override
	public void postMovie(MovieDTO movie) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public MovieDTO getMovieById() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(int id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMovie(MovieDTO movieDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public FileDTO selectFileById(int id, int movieId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
