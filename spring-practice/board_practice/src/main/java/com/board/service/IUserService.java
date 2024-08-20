package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.User;
import com.board.mapper.UserMapper;

@Service
public class IUserService implements UserService {
	@Autowired
	private UserMapper um;

	@Override
	public List<User> getAll() throws Exception {
		return um.getAllUser();
	}

	@Override
	public boolean addUser(User user) {
		try {
			um.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public User getUserById(int id) throws Exception {
		return um.getUser(id);
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			um.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
