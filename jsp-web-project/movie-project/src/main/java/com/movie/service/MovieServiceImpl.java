package com.movie.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.movie.dao.MovieDAO;
import com.movie.dao.MovieDAOImpl;
import com.movie.model.Movie;

public class MovieServiceImpl implements MovieService {
	private static final MovieDAO movieDAO = new MovieDAOImpl();

	// image명을 날짜와 시간으로 바꾸는 메소드
	private String saveImg(HttpServletRequest req) throws IOException, ServletException {
		Part part = req.getPart("poster");
		String header = part.getHeader("content-disposition");
		int start = header.indexOf("filename=");
		String poster = header.substring(start + 10, header.length() - 1);

		if (poster != null && !poster.isEmpty()) {
			StringBuilder img = new StringBuilder();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmSS");
			String time = dateFormat.format(cal.getTime());
			img.append(time).append(poster.substring(poster.lastIndexOf(".")));
			poster = img.toString();
			part.write(poster);
		} else {
			poster = "default.jpg";
		}

		return poster;
	}

	@Override
	public void addMovie(HttpServletRequest req) throws Exception {
		// 요청한 파라미터(title, summary, genre, director, actors, poster, release_date)
		String title = req.getParameter("title");
		String summary = req.getParameter("summary");
		String genre = req.getParameter("genre");
		String director = req.getParameter("director");
		String actors = req.getParameter("actors");
		String release_date = req.getParameter("release_date");

		String poster = saveImg(req);

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

		String img = saveImg(req);

		// DB에 update
		movieDAO.updateMovie(movie);
	}

}
