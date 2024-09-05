package com.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.domain.SignUpRequest;
import com.blog.domain.UpdateUserRequest;
import com.blog.domain.UserDeleteRequest;
import com.blog.domain.UserResponse;
import com.blog.entity.User;
import com.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public UserResponse addUser(SignUpRequest user) {
		User newUser = User.builder().email(user.getEmail()).name(user.getName()).password(user.getPassword()).build();
		User joinedUser = userRepository.save(newUser);

		return UserResponse.toDTO(joinedUser);
	}

	@Override
	public List<UserResponse> getAllUser() {
		List<User> userList = userRepository.findAll();

		if (userList.size() > 0) {
			List<UserResponse> result = userList.stream().map(UserResponse::toDTO).toList();
			return result;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public UserResponse updateUserInfo(UpdateUserRequest userDTO) {
		User user = userRepository.findByEmail(userDTO.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("회원 정보 조회에 실패했습니다. [없는 이메일]"));

		if (!user.getPassword().equals(userDTO.getPassword())) {
			throw new RuntimeException("비밀번호 입력 오류");
		}

		if (userDTO.getName() != null)
			user.setName(userDTO.getName());
		User updatedUser = userRepository.save(user);

		return UserResponse.toDTO(updatedUser);
	}

	@Override
	public boolean duplicateCheckEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public void deleteUser(UserDeleteRequest userDeleteRequest) {
		User user = userRepository.findByEmail(userDeleteRequest.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("회원 정보 조회에 실패했습니다. [없는 이메일]"));
		if (!user.getPassword().equals(userDeleteRequest.getPassword())) {
			throw new RuntimeException("비밀번호 입력 오류");
		}
		userRepository.delete(user);
	}

}
