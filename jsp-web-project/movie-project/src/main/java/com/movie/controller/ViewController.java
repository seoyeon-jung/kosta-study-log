package com.movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.model.Movie;
import com.movie.service.MovieService;
import com.movie.service.MovieServiceImpl;

public class ViewController implements MovieController {
	private static final MovieService ms = new MovieServiceImpl();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String action = req.getParameter("action");

			if (action != null && action.equals("updateMovie")) {
				// 영화 정보 수정하기
				ms.updateMovie(req);
				res.sendRedirect("/movie/movie?id=" + req.getParameter("id"));
				return;
			} else {
				// 영화 정보 출력하기
				Movie movie = ms.getMovie(req);
				req.setAttribute("movie", movie);
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("/movie/movieList");
			return;
		}
		String view = "/WEB-INF/views/movie.jsp";
		req.getRequestDispatcher(view).forward(req, res);
	}

}
