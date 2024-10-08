package com.report.service;

import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.report.domain.UserDTO;
import com.report.entity.User;
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
	public void join(UserDTO userDTO) throws Exception {
		// 중복 이메일 및 닉네임 체크
		if (userRepository.existsByEmail(userDTO.getEmail())) {
			throw new Exception("이미 사용중인 이메일입니다.");
		}
		if (userRepository.existsByUsername(userDTO.getUsername())) {
			throw new Exception("이미 사용중인 닉네임입니다.");
		}

		String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encodedPassword);
		userRepository.save(userDTO.setUser());
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteById(Long id) throws Exception {
		userRepository.deleteById(id);
	}

	@Override
	public User findById(Long id) throws Exception {
		User user = userRepository.findById(id).orElseThrow(() -> new Exception("ID가 존재하지 않습니다"));
		return user;
	}

	@Override
	public void editUser(Long id, String username, String email) throws Exception {
		User originUser = userRepository.findById(id).orElseThrow(() -> new Exception("ID가 존재하지 않습니다"));

		originUser.setUsername(username);
		originUser.setEmail(email);

		userRepository.save(originUser);

	}
}
