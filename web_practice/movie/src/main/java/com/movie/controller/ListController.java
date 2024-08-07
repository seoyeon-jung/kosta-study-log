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

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			MovieService movie = new MovieServiceImpl();

			String action = req.getParameter("action");
			if (action != null && action.equals("addMovie")) {
				// 영화 추가
				return;
			} else if (action != null && action.equals("deleteMovie")) {
				// 영화 삭제
				return;
			} else {
				// 전체 영화 리스트 출력
				List<Movie> movieList = movie.getAllMovies();
				req.setAttribute("newsList", movieList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String view = "/WEB-INF/views/movieList.jsp";
		req.getRequestDispatcher(view).forward(req, res);
	}

}
