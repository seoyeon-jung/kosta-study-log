package com.news.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.news.dao.INewsDAO;
import com.news.dao.NewsDAO;
import com.news.model.NewsDTO;

public class INewsService implements NewService {
	private NewsDAO newsDAO = new INewsDAO();

	@Override
	public List<NewsDTO> getAll() throws Exception {
		return newsDAO.getAllMewsList();
	}

	@Override
	public void addNews(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void getNews(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNews(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void editNews(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub

	}

}
