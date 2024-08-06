package com.maven.service;

import java.util.List;

import com.maven.dao.UserDAO;
import com.maven.model.User;

// service: 비지니스 로직
// dao에서 접근한 것을 가져온다.
public class UserService {
	// DB가 손상되지 않도록 여기서 지정
	private UserDAO userDAO = new UserDAO();

	// user를 추가하는 메소드
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	// userList를 가져오는 메소드
	public List<User> getAllUserList() {
		return userDAO.getAllUserList();
	}
}
