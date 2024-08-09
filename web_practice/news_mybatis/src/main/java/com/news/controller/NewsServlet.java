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

// 해당 서블릿 경로 설정
@WebServlet("/news")
// 이미지 저장 경로 설정
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, location = "C:\\Users\\WD\\news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// url 주소에 따른 동작을 수행할 수 있도록 map 생성
	Map<String, NewsController> controllerMap = new HashMap<>();

	public NewsServlet() {
		controllerMap.put("/news", new ListController());
		controllerMap.put("/news/detail", new DetailController());
		controllerMap.put("/news/add", new AddController());
		controllerMap.put("/news/edit", new EditController());
		controllerMap.put("/news/delete", new DeleteController());
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// POST 요청 시 서버에 한글 인코딩 전송
		req.setCharacterEncoding("UTF-8");

		// URI를 가져와서 URI에 맞는 controller 얻기
		String uri = req.getRequestURI();
		NewsController controller = controllerMap.get(uri);

		// 만약 해당 URI에 맞는 컨트롤러가 없으면, 404 error
		if (controller == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		// 맞는 컨트롤러가 있으면 process method 호출
		controller.process(req, res);

	}

}
