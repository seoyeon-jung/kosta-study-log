package com.movie.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.movie.dao.IMovieDAO;
import com.movie.dao.MovieDAO;
import com.movie.model.MovieDTO;

public class IMovieService implements MovieService {
	private static final MovieDAO movieDAO = new IMovieDAO();

	private String saveImg(HttpServletRequest req, String name) throws IOException, ServletException {
		// img를 가져와서 content-dispostion 작성하는 값을 가져오고, 그 값에서 파일명을 가져온다.
		Part part = req.getPart(name);
		String header = part.getHeader("content-disposition");
		int start = header.indexOf("filename=");

		// 파일명(originImg)가 존재하는 경우에는 파일명을 현재 날짜(연월일시분초)로 변경하여 저장시킨다.
		String originImg = header.substring(start + 10, header.length() - 1);
		if (originImg != null && !originImg.isEmpty()) {
			StringBuilder img = new StringBuilder();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmSS");
			String time = dateFormat.format(cal.getTime());
			img.append(time).append(originImg.substring(originImg.lastIndexOf(".")));
			originImg = img.toString();
			part.write(originImg);
		} else {
			// 파일명이 존재하지 않는 경우에는 파일명을 default.jpg로 한다.
			originImg = "default.jpg";
		}
		// 파일명을 반환한다.
		return originImg;
	}

	@Override
	public void addMovie(HttpServletRequest req) throws Exception {
		String title = req.getParameter("title");
		String summary = req.getParameter("summary");
		String genre = req.getParameter("genre");
		String director = req.getParameter("director");
		String actors = req.getParameter("actors");
		String release_date = req.getParameter("release_date");

		String poster = saveImg(req, "poster");

		MovieDTO movie = new MovieDTO(title, summary, genre, director, actors, poster, release_date);

		movieDAO.addMovie(movie);

	}

	@Override
	public List<MovieDTO> getAllMovies() throws Exception {
		return movieDAO.getAllMovies();
	}

	@Override
	public MovieDTO getMovie(HttpServletRequest req) throws Exception {
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
		MovieDTO movie = movieDAO.getMovie(id);

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

		String img = saveImg(req, "poster");

		movieDAO.updateMovie(movie);

	}

}
