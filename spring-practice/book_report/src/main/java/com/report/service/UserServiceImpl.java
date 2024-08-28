package com.report.service;

import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.report.domain.UserDTO;
import com.report.domain.UserGrade;
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
	public void join(UserDTO userDTO) {
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
	public void updateUser(Long id, Long point, UserGrade grade) throws Exception {
		User user = userRepository.findById(id).orElseThrow(() -> new Exception("ID가 존재하지 않습니다"));
		user.setPoint(point);
		user.setGrade(grade);
		userRepository.save(user);

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
