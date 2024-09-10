package com.blog.service.impl;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("[loadUserByUsername] 사용자 조회, username: {}", email);
		User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("없는 이메일"));
		return user;
	}

}
