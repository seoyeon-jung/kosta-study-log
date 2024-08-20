package com.board.service;

import java.util.List;

import com.board.dto.User;

public interface UserService {

	// 유저 리스트 가져오기
	List<User> getAll() throws Exception;

	// 유저 추가
	boolean addUser(User user);

	// 유저 정보 보여주기
	User getUserById(int id) throws Exception;

	// 유저 정보 삭제
	boolean deleteUser(int id);

}
