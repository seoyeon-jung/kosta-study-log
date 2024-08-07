package com.news.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/news/*")
@MultipartConfig(maxFileSize = 1020 * 1024 * 2, location = "C:\\Users\\WD")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, NewsController> controllerMap = new HashMap<>();

	public NewsServlet() {
		// uri, 구현할 객체
		controllerMap.put("/news/newsList", new ListController());
		controllerMap.put("/news/newsView", new ViewController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String requestURI = req.getRequestURI();
		System.out.println(requestURI);

		// requestURI를 받아와서 requestURI에 따라 다른 process를 불러와서 해당 페이지를 화면에 불러오면 된다.
		NewsController controller = controllerMap.get(requestURI);
		if (controller == null) {
			// 기본적으로 list를 띄울수 있도록 한다.
			// controller = controllerMap.get("/news/newsList");
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		controller.process(req, res);
	}

}
