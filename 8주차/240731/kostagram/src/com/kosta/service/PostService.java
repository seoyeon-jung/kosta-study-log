package com.kosta.service;

import java.sql.SQLException;

public interface PostService {
	void getPostList() throws SQLException;

	void addPost();

	// void getPost();

	void modifyPost();

	void delPost();

	void addLike();

	void delLike();
}
