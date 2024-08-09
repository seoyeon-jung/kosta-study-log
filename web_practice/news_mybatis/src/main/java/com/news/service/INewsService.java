package com.news.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.news.dao.INewsDAO;
import com.news.dao.NewsDAO;
import com.news.model.NewsDTO;

public class INewsService implements NewsService {
	private NewsDAO newsDAO = new INewsDAO();

	private String saveImg(HttpServletRequest req, String name) throws IOException, ServletException {
		// img를 가져와서 content-dispostion 작성하는 값을 가져오고, 그 값에서 파일명을 가져온다.
		Part part = req.getPart(name);
		String header = part.getHeader("content-disposition");
		int start = header.indexOf("filename=");

		// 파일명(originImg)가 존재하는 경우에는 파일명을 현재 날짜(연월일시분초)로 변경하여 저장시킨다.
		String originImg = header.substring(start + 10, header.length() - 1);
		if (originImg != null && !originImg.isEmpty()) {
			StringBuilder img = new StringBuilder();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmSS");
			String time = dateFormat.format(cal.getTime());
			img.append(time).append(originImg.substring(originImg.lastIndexOf(".")));
			originImg = img.toString();
			part.write(originImg);
		} else {
			// 파일명이 존재하지 않는 경우에는 파일명을 default.jpg로 한다.
			originImg = "default.jpg";
		}
		// 파일명을 반환한다.
		return originImg;
	}

	@Override
	public List<NewsDTO> getAll() throws Exception {
		return newsDAO.getAllMewsList();
	}

	@Override
	public void addNews(HttpServletRequest req) throws Exception {
		String title = req.getParameter("title");
		String content = req.getParameter("title");
		String img = saveImg(req, "img");

		NewsDTO newsDTO = new NewsDTO(0, title, img, null, content);
		newsDAO.insertNews(newsDTO);

	}

	@Override
	public NewsDTO getNews(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		return newsDAO.getNewsById(id);

	}

	@Override
	public void removeNews(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		newsDAO.deleteNewsById(id);
	}

	@Override
	public void editNews(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("title");
		String img = saveImg(req, "img");

		NewsDTO news = newsDAO.getNewsById(id);
		news.setTitle(title);
		news.setContent(content);
		news.setImg(img);

		newsDAO.updateNews(news);

	}

}
