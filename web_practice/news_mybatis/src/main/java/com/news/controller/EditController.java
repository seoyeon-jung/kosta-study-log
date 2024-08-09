package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.NewsDTO;
import com.news.service.INewsService;
import com.news.service.NewsService;

public class EditController implements NewsController {
	private NewsService ns = new INewsService();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/add.jsp";
		try {
			if (req.getMethod().equals("POST")) {
				// POST 방식에는 DB에서 수정시켜주고 detail page로 이동
				ns.editNews(req);
				viewPath = "/WEB-INF/views/detail.jsp";
			}
			// POST 방식이 아닐 때는 기사 수정 화면을 보여준다
			NewsDTO news = ns.getNews(req);
			req.setAttribute("news", news);
			req.getRequestDispatcher(viewPath).forward(req, res);
			return;

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher(viewPath).forward(req, res);
	}

}
