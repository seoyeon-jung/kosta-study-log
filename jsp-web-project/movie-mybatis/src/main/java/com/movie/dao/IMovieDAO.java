package com.movie.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.movie.config.SQLSessionFactory;
import com.movie.model.MovieDTO;

public class IMovieDAO implements MovieDAO {
	private SqlSessionFactory ssf = SQLSessionFactory.getSsf();

	@Override
	public void addMovie(MovieDTO movie) throws Exception {
		SqlSession sqlSession = ssf.openSession(true);
		sqlSession.insert("addMovie", movie);
		sqlSession.close();

	}

	@Override
	public List<MovieDTO> getAllMovies() throws Exception {
		SqlSession sqlSession = ssf.openSession(true);
		List<MovieDTO> movieList = sqlSession.selectList("getAllMovies");
		sqlSession.close();
		return movieList;
	}

	@Override
	public MovieDTO getMovie(int id) throws Exception {
		SqlSession sqlSession = ssf.openSession(true);
		MovieDTO movie = sqlSession.selectOne("getMovie", id);
		sqlSession.close();
		return movie;
	}

	@Override
	public void deleteMovie(int id) throws Exception {
		SqlSession sqlSession = ssf.openSession(true);
		sqlSession.delete("deleteMovie", id);
		sqlSession.close();

	}

	@Override
	public void updateMovie(MovieDTO movie) throws Exception {
		SqlSession sqlSession = ssf.openSession(true);
		sqlSession.update("updateMovie", movie);
		sqlSession.clearCache();

	}

}
