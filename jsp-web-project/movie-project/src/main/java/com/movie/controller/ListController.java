package com.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.model.Movie;
import com.movie.service.MovieService;
import com.movie.service.MovieServiceImpl;

public class ListController implements MovieController {
	private static final MovieService ms = new MovieServiceImpl();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String action = req.getParameter("action");
			if (action != null && action.equals("addMovie")) {
				// 영화 추가
				ms.addMovie(req);
				res.sendRedirect(req.getRequestURI());
				return;
			} else if (action != null && action.equals("deleteMovie")) {
				// 영화 삭제
				ms.deleteMovie(req);
				res.sendRedirect(req.getRequestURI());
				return;
			} else {
				// 전체 영화 리스트 출력
				List<Movie> movieList = ms.getAllMovies();
				req.setAttribute("movieList", movieList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String view = "/WEB-INF/views/movieList.jsp";
		req.getRequestDispatcher(view).forward(req, res);

	}

}
