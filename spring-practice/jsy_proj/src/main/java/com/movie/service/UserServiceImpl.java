package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dto.UserDTO;
import com.movie.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper um;

	@Override
	public List<UserDTO> getAllUserList() throws Exception {
		return um.selectAllUser();
	}

	@Override
	public void addUser(UserDTO userDTO) throws Exception {
		um.insertUser(userDTO);

	}

	@Override
	public void removeUser(int id) throws Exception {
		um.deleteUser(id);
	}

}
