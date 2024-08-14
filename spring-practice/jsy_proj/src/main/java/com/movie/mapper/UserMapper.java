package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movie.dto.UserDTO;

@Mapper
public interface UserMapper {
	// 삭제 안된 회원 리스트 가져오기
	List<UserDTO> selectAllUser() throws Exception;

	// 회원 추가하기
	void insertUser(UserDTO userDTO) throws Exception;

	// 회원 삭제하기
	void deleteUser(int id) throws Exception;
}
