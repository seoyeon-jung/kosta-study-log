package com.movie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.movie.dao.MovieDAO;
import com.movie.dao.MovieDAOImpl;
import com.movie.model.Movie;

public class MovieServiceImpl implements MovieService {
	private static final MovieDAO movieDAO = new MovieDAOImpl();

	@Override
	public void addMovie(HttpServletRequest req) throws Exception {
		// 요청한 파라미터(title, summary, gerne, director, actors, poster, release_date)
		String title = req.getParameter("title");
		String summary = req.getParameter("summary");
		String gerne = req.getParameter("genre");
		String director = req.getParameter("director");
		String actors = req.getParameter("actors");
		String poster = req.getParameter("poster");
		String release_date = req.getParameter("release_date");

		// image 가져오기 getPart()
		Part part = req.getPart("img");
		String header = part.getHeader("content-disposition");
		// header에서 filename 찾아서 가져오기
		int start = header.indexOf("filename=");
		String img = header.substring(start + 10, header.length() - 1);
		// img 저장하기
		if (img != null && !img.isEmpty()) {
			part.write(img);
		}

		// Movie 객체에 저장
		Movie movie = new Movie(title, summary, gerne, director, actors, poster, release_date);

		// DB에 저장
		movieDAO.addMovie(movie);

	}

	@Override
	public List<Movie> getAllMovies() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovie(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMovie(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub

	}

}
