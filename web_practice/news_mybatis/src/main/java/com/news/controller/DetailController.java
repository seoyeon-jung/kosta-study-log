package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.NewsDTO;
import com.news.service.INewsService;
import com.news.service.NewsService;

public class DetailController implements NewsController {
	private NewsService ns = new INewsService();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			NewsDTO news = ns.getNews(req);
			req.setAttribute("news", news);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}

		String viewPath = "/WEB-INF/views/detail.jsp";
		req.getRequestDispatcher(viewPath).forward(req, res);
	}

}
