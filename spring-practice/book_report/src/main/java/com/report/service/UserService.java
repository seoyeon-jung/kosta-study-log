package com.report.service;

import com.report.domain.UserDTO;

public interface UserService {

	boolean isLogin();

	void join(UserDTO userDTO);

}
