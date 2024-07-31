package com.kosta.service;

import java.sql.SQLException;
import java.util.Date;

import com.kosta.controller.KostagramExample;
import com.kosta.model.Post;
import com.kosta.model.User;

public class PostServiceImpl implements PostService {

	private static UserService us = new UserServiceImpl();

	@Override
	public void getPostList() throws SQLException {
		System.out.println("\n =============== 전체 게시물 ===============");
		String sql = "SELECT * FROM posts WHERE deleted_at IS NULL";

		KostagramExample.pstmt = KostagramExample.conn.prepareStatement(sql);
		KostagramExample.rs = KostagramExample.pstmt.executeQuery();

		while (KostagramExample.rs.next()) {
			int id = KostagramExample.rs.getInt(1);
			int user_id = KostagramExample.rs.getInt(2);
			String content = KostagramExample.rs.getString(3);
			String image = KostagramExample.rs.getString(4);
			Date created_at = KostagramExample.rs.getDate(5);
			Date updated_at = KostagramExample.rs.getDate(6);

			User u = us.getUser(user_id);

			Post p = new Post(id, u, content, image, null, null, null);

			System.out.println(p);
		}

	}

	private UserService UserServiceImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPost() {
		System.out.println("\n =============== 게시물 작성 ===============");

	}

	@Override
	public void modifyPost() {
		System.out.println("\n =============== 게시물 수정 ===============");

	}

	@Override
	public void delPost() {
		System.out.println("\n =============== 게시물 삭제 ===============");

	}

	@Override
	public void addLike() {
		System.out.println("\n =============== 좋아요 누르기 ===============");

	}

	@Override
	public void delLike() {
		System.out.println("\n =============== 좋아요 취소 ===============");

	}

}
