package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.domain.request.SignUpRequest;
import com.blog.domain.request.UpdateUserRequest;
import com.blog.domain.request.UserDeleteRequest;
import com.blog.domain.response.UserResponse;
import com.blog.entity.User;
import com.blog.repository.UserRepository;
import com.blog.security.JwtProvider;
import com.blog.service.UserService;
import com.blog.util.TokenUtils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final JwtProvider jwtProvider;
	private final TokenUtils tokenUtils;

	@Override
	public UserResponse addUser(SignUpRequest user) {
		// 사용자의 비밀번호 암호화
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

		User newUser = User.builder().email(user.getEmail()).name(user.getName()).password(encodedPassword).build();
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

		boolean isMatch = bCryptPasswordEncoder.matches(userDTO.getPassword(), user.getPassword());
		if (!isMatch) {
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
		boolean isMatch = bCryptPasswordEncoder.matches(userDeleteRequest.getPassword(), user.getPassword());
		if (!isMatch) {
			throw new RuntimeException("비밀번호 입력 오류");
		}
		userRepository.delete(user);
	}

	// refresh token 추출 메서드
	private String extractRefreshTokenFromCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("refreshToken")) {
					return c.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public Map<String, String> refreshToken(HttpServletRequest req) {
		// refresh token 추출
		String refreshToken = extractRefreshTokenFromCookie(req);

		// 만약 토큰이 유효하지 않으면 null
		if (refreshToken == null || !jwtProvider.validateToken(refreshToken)) {
			return null;
		}

		// 유효한 token에서 이메일 추출
		String userEmail = jwtProvider.getUserEmailByToken(refreshToken);
		// 이메일을 통한 사용자 조회
		User user = userRepository.findByEmail(userEmail).orElse(null);
		// refreshtoken 비교
		if (user == null || !user.getRefreshToken().equals(refreshToken)) {
			return null;
		}

		// 새로운 token 생성 후 DB에 refreshToken 저장
		Map<String, String> tokenMap = tokenUtils.generateToken(user);
		user.setRefreshToken(tokenMap.get("refreshToken"));
		userRepository.save(user);

		return tokenMap;
	}

}
