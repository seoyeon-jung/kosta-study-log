package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.model.News;
import com.news.util.ConnetionPool.DBPool;

public class NewsDAOImpl implements NewsDAO {

	@Override
	public void addNews(News news) throws Exception {
		String sql = "INSERT INTO news (title, img, content) VALUES (?, ?, ?)";
		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getImg());
			pstmt.setString(3, news.getContent());
			pstmt.executeUpdate();
		}

	}

	@Override
	public List<News> getAll() throws Exception {
		String sql = "SELECT * FROM news";
		List<News> newsList = new ArrayList<>();
		try (Connection conn = DBPool.getDBPool();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String img = rs.getString("img");
				String date = rs.getString("date");
				String content = rs.getString("content");

				News news = new News(id, title, img, date, content);
				newsList.add(news);
			}
		}

		return newsList;
	}

	@Override
	public News getNews(int id) throws Exception {
		String sql = "SELECT * FROM news WHERE id = ?";
		News news = null;

		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String img = rs.getString("img");
				String date = rs.getString("date");
				String content = rs.getString("content");

				news = new News(id, title, img, date, content);
			}
		}
		return news;

	}

	@Override
	public void deleteNews(int id) throws Exception {
		String sql = "DELETE FROM news WHERE id = ?";
		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}

	}

	@Override
	public void modifyNews(News news) throws Exception {
		String sql = "UPDATE news SET title = ?, img = ?, date = NOW(), content = ? WHERE id = ?";
		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getImg());
			pstmt.setString(3, news.getContent());
			pstmt.setInt(4, news.getId());
			pstmt.executeUpdate();
		}

	}

}
