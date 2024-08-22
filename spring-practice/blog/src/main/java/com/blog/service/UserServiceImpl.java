package com.blog.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Long save(User user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user).getId();
	}

}
