package com.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.News;
import com.news.service.NewsService;
import com.news.service.NewsServiceImpl;

public class ListController implements NewsController {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			NewsService ns = new NewsServiceImpl();

			// parameter를 가져와서 aciton값에 따라 다르게 나오도록
			String action = req.getParameter("action");
			if (action != null && action.equals("addNews")) {
				System.out.println("기사 추가");
				ns.addNews(req);
				res.sendRedirect(req.getRequestURI());
				return;
			} else if (action != null && action.equals("deleteNews")) {
				System.out.println("기사 삭제");
				ns.deleteNews(req);
				res.sendRedirect(req.getRequestURI());
				return;
			} else {
				System.out.println("기사 전체 보기");
				List<News> list = ns.getAll();
				req.setAttribute("newsList", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e);
		}

		String view = "/WEB-INF/views/NewsList.jsp";
		req.getRequestDispatcher(view).forward(req, res);

	}

}
