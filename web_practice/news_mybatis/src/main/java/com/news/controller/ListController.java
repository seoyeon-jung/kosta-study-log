package com.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.NewsDTO;
import com.news.service.INewsService;
import com.news.service.NewsService;

public class ListController implements NewsController {
	private NewsService ns = new INewsService();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			System.out.println("기사 전체 보기");
			List<NewsDTO> newsList = ns.getAll();
			req.setAttribute("newsList", newsList);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}

		String viewPath = "/WEB-INF/views/list.jsp";
		req.getRequestDispatcher(viewPath).forward(req, res);
	}

}
