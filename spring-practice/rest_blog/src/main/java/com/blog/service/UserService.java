package com.blog.service;

import java.util.List;

import com.blog.domain.LoginResponse;
import com.blog.domain.SignUpRequest;
import com.blog.domain.UpdateUserRequest;
import com.blog.domain.UserDeleteRequest;
import com.blog.domain.UserResponse;

public interface UserService {

	UserResponse addUser(SignUpRequest user);

	List<UserResponse> getAllUser();

	UserResponse updateUserInfo(UpdateUserRequest user);

	boolean duplicateCheckEmail(String string);

	void deleteUser(UserDeleteRequest userDeleteRequest);

	LoginResponse login(String email, String password);

}
