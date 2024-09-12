package com.product.security;

import java.io.IOException;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.product.domain.token.TokenResponse;
import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.utils.TokenUtils;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationService {
	private final TokenUtils tokenUtils;
	private final UserRepository userRepository;

	void successAuthentication(HttpServletResponse response, Authentication authResult) throws IOException {
		User user = (User) authResult.getPrincipal();
		Map<String, String> tokenMap = tokenUtils.generateToken(user);
		String accessToken = tokenMap.get("accessToken");
		String refreshToken = tokenMap.get("refreshToken");

		// refresh tokem >> DB에 저장
		user.setRefreshToken(refreshToken);
		userRepository.save(user);

		// 생성된 refresh token을 cookie에 담아 응답
		tokenUtils.setRefreshTokenCookie(response, refreshToken);

		// 생성된 access token을 LoginResponse에 담아 응답
		TokenResponse loginResponse = TokenResponse.builder().accessToken(accessToken).build();
		tokenUtils.writeResponse(response, loginResponse);
	}
}
