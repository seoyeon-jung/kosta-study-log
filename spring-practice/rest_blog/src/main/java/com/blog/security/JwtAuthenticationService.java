package com.blog.security;

import java.io.IOException;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.blog.domain.response.LoginResponse;
import com.blog.entity.User;
import com.blog.repository.UserRepository;
import com.blog.util.TokenUtils;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

// 인증 관련 서비스 진행
@Service
@RequiredArgsConstructor
public class JwtAuthenticationService {
	private final TokenUtils tokenUtils;
	private final UserRepository userRepository;

	void successAuthentication(HttpServletResponse response, Authentication authResult) throws IOException {
		User user = (User) authResult.getPrincipal(); // authResult의 유저 정보 가져오기

		// tokenUtils에 user 넣어서 토큰 생성
		Map<String, String> tokenMap = tokenUtils.generateToken(user);
		String accessToken = tokenMap.get("accessToken");
		String refreshToken = tokenMap.get("refreshToken");

		// refresh token을 DB에 저장
		user.setRefreshToken(refreshToken);
		userRepository.save(user);

		// 생성된 refresh token을 cookie에 담아 저장
		tokenUtils.setRefreshTokenCookie(response, refreshToken);

		// loginRespnse에 token 담아서 응답
		LoginResponse loginResponse = LoginResponse.builder().accessToken(accessToken).build();

		tokenUtils.writeResponse(response, loginResponse);

	}

}
