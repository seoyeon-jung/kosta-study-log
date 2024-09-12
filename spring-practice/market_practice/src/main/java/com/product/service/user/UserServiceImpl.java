package com.product.service.user;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.product.domain.join.JoinUser;
import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.security.JwtProvider;
import com.product.utils.TokenUtils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final TokenUtils tokenUtils;
	private final JwtProvider jwtProvider;

	// 회원가입
	@Override
	public void addUser(JoinUser joinUser) throws Exception {
		String encodedPassword = bCryptPasswordEncoder.encode(joinUser.getPassword());
		User user = User.builder().name(joinUser.getName()).email(joinUser.getEmail()).password(encodedPassword)
				.build();
		userRepository.save(user);
	}

	// 이메일 중복 체크
	@Override
	public boolean checkEmailExists(String email) {
		return userRepository.existsByEmail(email);
	}

	// 토큰 재발급
	@Override
	public Map<String, String> refreshToken(HttpServletRequest request) {
		String refreshToken = extractRefreshTokenFromCookie(request);
		if (refreshToken != null && jwtProvider.validateToken(refreshToken)) {
			String userEmail = jwtProvider.getUserEmailByToken(refreshToken);
			User user = userRepository.findByEmail(userEmail).orElse(null);

			if (user != null && user.getRefreshToken().equals(refreshToken)) {
				Map<String, String> tokenMap = tokenUtils.generateToken(user);
				user.setRefreshToken(tokenMap.get("refreshToken"));
				userRepository.save(user);
				return tokenMap;
			}
		}
		return null;
	}

	private String extractRefreshTokenFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("refreshToken")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// name 중복 체크 (nickname)
	@Override
	public boolean checkNameExists(String name) {
		return userRepository.existsByName(name);
	}

}
