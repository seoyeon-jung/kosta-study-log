package com.movie.service;

import java.util.List;

import com.movie.dto.UserDTO;

public interface UserService {
	// 삭제 안된 회원 리스트 가져오기
	List<UserDTO> getAllUserList() throws Exception;

	// 회원 추가하기
	void addUser(UserDTO userDTO) throws Exception;

	// 회원 삭제하기
	void removeUser(int id) throws Exception;
}
