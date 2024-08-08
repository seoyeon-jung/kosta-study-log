package com.movie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movie/*")
@MultipartConfig(maxFileSize = 1020 * 1020 * 2, location = "C:\\Users\\WD\\movieImage")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, MovieController> controllerMap = new HashMap<>();

	public MovieServlet() {
		controllerMap.put("/movie/movieList", new ListController());
		controllerMap.put("/movie/movie", new ViewController());
		controllerMap.put("/movie/post", new PostController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String requestURI = req.getRequestURI();

		MovieController controller = controllerMap.get(requestURI);
		if (controller == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		controller.process(req, res);
	}

}
