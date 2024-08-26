package com.report.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.report.domain.UserDTO;
import com.report.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean isLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken)
			return false;
		return auth.isAuthenticated();
	}

	@Override
	public void join(UserDTO userDTO) {
		String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encodedPassword);
		userRepository.save(userDTO.setUser());
	}
}
