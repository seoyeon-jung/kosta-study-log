package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.News;
import com.news.service.NewsService;
import com.news.service.NewsServiceImpl;

public class ViewController implements NewsController {
	NewsService ns = new NewsServiceImpl();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String action = req.getParameter("action");
			if (action != null && action.equals("modifyNews")) {
				ns.moodifyNews(req);
				res.sendRedirect("/news/newsView?id=" + req.getParameter("id"));
			} else {
				News news = ns.getNews(req);
				req.setAttribute("news", news);
			}

		} catch (Exception e) {
			res.sendRedirect("news/newsList");
			return;
		}

		String view = "/WEB-INF/views/NewsView.jsp";
		req.getRequestDispatcher(view).forward(req, res);

	}

}
