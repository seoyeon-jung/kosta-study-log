package com.report.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.report.entity.User;
import com.report.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException(username));

		// 계정 잠금 여부 확인
		if (user.isAccountNonLocked() == false) {
			throw new UsernameNotFoundException(username + "계정이 잠겨 있습니다!");
		}

		return user;
	}

}
