package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.domain.request.SignUpRequest;
import com.blog.domain.request.UpdateUserRequest;
import com.blog.domain.request.UserDeleteRequest;
import com.blog.domain.response.UserResponse;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

	UserResponse addUser(SignUpRequest user);

	List<UserResponse> getAllUser();

	UserResponse updateUserInfo(UpdateUserRequest user);

	boolean duplicateCheckEmail(String string);

	void deleteUser(UserDeleteRequest userDeleteRequest);

	Map<String, String> refreshToken(HttpServletRequest req);

}
