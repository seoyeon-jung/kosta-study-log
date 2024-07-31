package com.kosta.service;

import java.sql.SQLException;

import com.kosta.model.User;

public interface UserService {

	// void getAllUserList();

	void getuser(int id) throws SQLException;

	// void updateUser();

	void addUser() throws SQLException;

	void delUser();

	void addFollow();

	void delFollow();

	void getFollowList();

	User getUser(int user_id);
}
