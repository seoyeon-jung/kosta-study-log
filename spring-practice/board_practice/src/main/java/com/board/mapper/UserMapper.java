package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.User;

@Mapper
public interface UserMapper {

	List<User> getAllUser() throws Exception;

	void insertUser(User user) throws Exception;

	User getUser(int id) throws Exception;

}
