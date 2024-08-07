package com.news.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.news.dao.NewsDAO;
import com.news.dao.NewsDAOImpl;
import com.news.model.News;

public class NewsServiceImpl implements NewsService {
	NewsDAO newsDAO = new NewsDAOImpl();

	@Override
	public void addNews(HttpServletRequest req) throws Exception {
		// 요청한 파라미터(title, img, content)를 가지고 News 객체 생성
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println("제목과 내용 : " + title + ", " + content);

		// image 가져오기 getPart()
		Part part = req.getPart("img");
		String header = part.getHeader("content-disposition");
		// header에서 filename 찾아서 가져오기
		int start = header.indexOf("filename=");
		String img = header.substring(start + 10, header.length() - 1);
		System.out.println(img);
		// img 저장하기
		if (img != null && !img.isEmpty()) {
			part.write(img);
		}

		// News 객체 생성
		News news = new News(title, img, content);

		// DAO한테 DB에 넣으라고 시킨다.
		newsDAO.addNews(news);
	}

	@Override
	public List<News> getAll() throws Exception {
		return newsDAO.getAll();
	}

	@Override
	public News getNews(HttpServletRequest req) throws Exception {
		return null;
	}

	@Override
	public void deleteNews(HttpServletRequest req) throws Exception {

	}

}
