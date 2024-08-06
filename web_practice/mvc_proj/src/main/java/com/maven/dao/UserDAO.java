package com.maven.dao;

import java.util.ArrayList;
import java.util.List;

import com.maven.model.User;

// dao : database에 접근하는 역할
public class UserDAO {
	// db가 없으므로 임의로 db를 지정
	private List<User> userDB = new ArrayList<>();

	// DB에 user 추가
	public void addUser(User user) {
		userDB.add(user);
	}

	// DB에 존재하는 userList 출력
	public List<User> getAllUserList() {
		return new ArrayList<>(userDB);
	}
}
