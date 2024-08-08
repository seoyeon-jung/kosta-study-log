package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie.model.Movie;
import com.movie.util.ConnectionPool.DBPool;

public class MovieDAOImpl implements MovieDAO {
	// 영화 추가
	@Override
	public void addMovie(Movie movie) throws Exception {
		String sql = "INSERT INTO movie (title, summary, genre, director, actors, poster, release_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getSummary());
			pstmt.setString(3, movie.getGenre());
			pstmt.setString(4, movie.getDirector());
			pstmt.setString(5, movie.getActors());
			pstmt.setString(6, movie.getPoster());
			pstmt.setString(7, movie.getRelease_date());

//			String releaseDateStr = movie.getRelease_date();
//			pstmt.setString(7, releaseDateStr.replaceAll(".", "-"));
//			if (releaseDateStr != null && !releaseDateStr.isEmpty()) {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
//				dateFormat.setLenient(false);
//				try {
//					java.util.Date parsedDate = dateFormat.parse(releaseDateStr);
//					java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
//					pstmt.setDate(7, sqlDate);
//				} catch (ParseException e) {
//					throw new Exception("유효하지 않은 날짜 형식입니다.");
//				}
//			} else {
//				pstmt.setNull(7, java.sql.Types.DATE); // NULL로 설정
//			}

			pstmt.executeUpdate();
		}
	}

	// 영화 리스트 출력
	@Override
	public List<Movie> getAllMovies() throws Exception {
		String sql = "SELECT * FROM movie";
		List<Movie> movieList = new ArrayList<>();
		try (Connection conn = DBPool.getDBPool();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String genre = rs.getString("genre");
				String director = rs.getString("director");
				String actors = rs.getString("actors");
				String poster = rs.getString("poster");
				String release_date = rs.getString("release_date");

				Movie movie = new Movie(id, title, summary, genre, director, actors, poster, release_date);
				movieList.add(movie);
			}
		}
		return movieList;
	}

	// 영화 정보 출력
	@Override
	public Movie getMovie(int id) throws Exception {
		String sql = "SELECT * FROM movie WHERE id = ?";
		Movie movie = null;

		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String genre = rs.getString("genre");
				String director = rs.getString("director");
				String actors = rs.getString("actors");
				String poster = rs.getString("poster");
				String release_date = rs.getString("release_date");

				movie = new Movie(id, title, summary, genre, director, actors, poster, release_date);
			}
		}
		return movie;
	}

	// 영화 삭제
	@Override
	public void deleteMovie(int id) throws Exception {
		String sql = "DELETE FROM movie WHERE id = ?";
		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	// 영화 정보 수정
	@Override
	public void updateMovie(Movie movie) throws Exception {
		String sql = "UPDATE movie SET title = ?, summary = ?, genre = ?, director = ?, actors = ?, poster = ?, release_date = ? WHERE id = ?";
		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getSummary());
			pstmt.setString(3, movie.getGenre());
			pstmt.setString(4, movie.getDirector());
			pstmt.setString(5, movie.getActors());
			pstmt.setString(6, movie.getPoster());
			pstmt.setString(7, movie.getRelease_date());
			pstmt.setInt(8, movie.getId());

			pstmt.executeUpdate();
		}
	}
}
