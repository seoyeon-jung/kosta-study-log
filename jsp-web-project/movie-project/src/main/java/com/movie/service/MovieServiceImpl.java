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
		// 요청한 파라미터(title, summary, genre, director, actors, poster, release_date)
		String title = req.getParameter("title");
		String summary = req.getParameter("summary");
		String genre = req.getParameter("genre");
		String director = req.getParameter("director");
		String actors = req.getParameter("actors");
		String release_date = req.getParameter("release_date");

		// image 가져오기 getPart()
		Part part = req.getPart("poster");
		String header = part.getHeader("content-disposition");
		// header에서 filename 찾아서 가져오기
		int start = header.indexOf("filename=");
		String poster = header.substring(start + 10, header.length() - 1);
		// img 저장하기
		if (poster != null && !poster.isEmpty()) {
			part.write(poster);
		}

		// Movie 객체에 저장
		Movie movie = new Movie(title, summary, genre, director, actors, poster, release_date);

		// DB에 저장
		movieDAO.addMovie(movie);

	}

	@Override
	public List<Movie> getAllMovies() throws Exception {
		return movieDAO.getAllMovies();
	}

	@Override
	public Movie getMovie(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		return movieDAO.getMovie(id);
	}

	@Override
	public void deleteMovie(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		movieDAO.deleteMovie(id);

	}

	@Override
	public void updateMovie(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));

		// 기존 객체 가져오기
		Movie movie = movieDAO.getMovie(id);

		// 객체의 정보 수정
		String title = req.getParameter("title");
		String summary = req.getParameter("summary");
		String genre = req.getParameter("genre");
		String director = req.getParameter("director");
		String actors = req.getParameter("actors");
		String release_date = req.getParameter("release_date");

		movie.setTitle(title);
		movie.setSummary(summary);
		movie.setGenre(genre);
		movie.setDirector(director);
		movie.setActors(actors);
		movie.setRelease_date(release_date);

		// poster 수정
		// image 가져오기 getPart()
		Part part = req.getPart("poster");
		String header = part.getHeader("content-disposition");
		// header에서 filename 찾아서 가져오기
		int start = header.indexOf("filename=");
		String poster = header.substring(start + 10, header.length() - 1);
		// img 저장하기
		if (poster != null && !poster.isEmpty()) {
			part.write(poster);
			movie.setPoster(poster);
		}

		// DB에 update
		movieDAO.updateMovie(movie);
	}

}
