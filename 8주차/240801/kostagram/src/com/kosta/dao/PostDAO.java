package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kosta.model.Post;
import com.kosta.util.DBConnection;

public class PostDAO {
	// DB에 새로 작성한 게시글 추가
	public int addPost(Post post) throws Exception {
		String sql = "INSERT INTO posts (user_id, content, image) VALUES (?, ?, ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, post.getUser_id());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getImage());

			return pstmt.executeUpdate();
		}

	}

	// DB에서 전체 게시물 가져오기
	public List<Post> getPostList() throws Exception {
		String sql = "SELECT * FROM posts WHERE deleted_at IS NULL";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			List<Post> postList = new ArrayList<>();

			while (rs.next()) {
				Post post = new Post(rs.getInt("id"), rs.getInt("user_id"), rs.getString("content"),
						rs.getString("image"), rs.getDate("created_at"), rs.getDate("update_at"),
						rs.getDate("deleted_at"));

				postList.add(post);
			}
			return postList;
		}
	}

	// DB에서 특정 게시물 id를 통해 해당 게시물 정보 가져오기
	public Post getPost(int id) throws Exception {
		String sql = "SELECT * FROM posts WHERE id = ? AND deleted_at IS NULL";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return new Post(rs.getInt("id"), rs.getInt("user_id"), rs.getString("content"), rs.getString("image"),
						rs.getDate("created_at"), rs.getDate("update_at"), rs.getDate("deleted_at"));
			}

		}
		return null;
	}

	// DB에서 특정 게시물 수정하기
	public int updatePost(Post newPost) throws Exception {
		String sql = "UPDATE posts SET content = ?, image = ? WHERE id = ? AND deleted_at IS NULL";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, newPost.getContent());
			pstmt.setString(2, newPost.getImage());
			pstmt.setInt(3, newPost.getId());

			return pstmt.executeUpdate();
		}
	}

	// DB에서 특정 게시물 삭제하기
	public int deletePost(int id) throws Exception {
		String sql = "UPDATE posts SET deleted_at = now() WHERE id = ? AND deleted_at IS NULL";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}
	}

	// DB에 좋아요 누른 결과를 업데이트 하기
	public int addLike(int user_id, int post_id) throws Exception {
		String sql = "INSERT INTO likes (user_id, post_id) VALUES (?, ?) "
				+ "ON DUPLICATE KEY UPDATE deleted_at = NULL";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, post_id);
			return pstmt.executeUpdate();
		}
	}

	// DB에서 특정 user가 좋아요를 누른 게시글 리스트를 가져오기
	public List<Post> getLikedPostListByUser(int user_id) throws Exception {
		// posts와 likes 테이블을 join해서 리스트를 가져와야 한다.
		String sql = "select p.* from posts p join likes l on l.post_id = p.id where l.user_id = ? AND l.deleted_at IS NULL AND p.deleted_at IS NULL";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			List<Post> postList = new ArrayList<>();

			while (rs.next()) {
				Post post = new Post(rs.getInt("id"), rs.getInt("user_id"), rs.getString("content"),
						rs.getString("image"), rs.getDate("created_at"), rs.getDate("update_at"),
						rs.getDate("deleted_at"));

				postList.add(post);
			}
			return postList;
		}
	}

	// DB에 좋아요 취소한 결과를 업데이트 하기
	public int deleteLike(int user_id, int post_id) throws Exception {
		String sql = "UPDATE likes SET deleted_at = now() WHERE user_id = ? AND post_id = ? AND deleted_at IS NULL";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, post_id);
			return pstmt.executeUpdate();
		}
	}

}
