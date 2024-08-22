package com.kosta.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.kosta.entity.User;
import com.kosta.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) {
		// email을 통해 가져온 유저가 담긴다
		// email이 없는 경우를 생각하기 위해 orElseThrow 추가
		User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
		return user;
	}

}
