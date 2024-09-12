package com.product.service.user;

import java.util.Map;

import com.product.domain.join.JoinUser;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

	void addUser(JoinUser joinUser) throws Exception;

	boolean checkEmailExists(String email);

	Map<String, String> refreshToken(HttpServletRequest request);

	boolean checkNameExists(String name);

}
