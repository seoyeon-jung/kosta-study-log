package com.report.service;

import java.util.List;

import com.report.domain.UserDTO;
import com.report.domain.UserGrade;
import com.report.entity.User;

public interface UserService {

	boolean isLogin();

	void join(UserDTO userDTO) throws Exception;

	List<User> findAll();

	void deleteById(Long id) throws Exception;

	void updateUser(Long id, Long point, UserGrade grade, Boolean locked) throws Exception;

	User findById(Long id) throws Exception;

	void editUser(Long id, String username, String email) throws Exception;

}
