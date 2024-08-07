package com.movie.dao;

import java.util.List;

import com.movie.model.Movie;

public class MovieDAOImpl implements MovieDAO {

	// 영화 추가
	@Override
	public void addMovie(Movie movie) throws Exception {
		String sql = "INSERT INTO movie (title, summary, gerne, director, actors, poster, release_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
	}

	// 영화 리스트 출력
	@Override
	public List<Movie> getAllMovies() throws Exception {
		return null;
	}

	// 영화 정보 출력
	@Override
	public Movie getMovie() throws Exception {
		return null;
	}

	// 영화 삭제
	@Override
	public void deleteMovie(int id) throws Exception {

	}

	// 영화 정보 수정
	@Override
	public void updateMovie(int id) throws Exception {
	}

}
