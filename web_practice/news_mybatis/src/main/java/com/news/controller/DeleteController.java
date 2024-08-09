package com.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.NewsDTO;
import com.news.service.INewsService;
import com.news.service.NewsService;

public class DeleteController implements NewsController {
	private NewsService ns = new INewsService();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			if (req.getMethod().equals("POST")) {
				ns.removeNews(req);
				res.sendRedirect("/news");
				return;
			} else {
				List<NewsDTO> newsList = ns.getAll();
				req.setAttribute("newsList", newsList);
				throw new Exception("허용되지 않은 동작입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}

		String viewPath = "/WEB-INF/views/list.jsp";
		req.getRequestDispatcher(viewPath).forward(req, res);
	}

}
