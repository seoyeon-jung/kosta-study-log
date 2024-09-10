package com.blog.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.blog.domain.response.LoginResponse;
import com.blog.entity.User;
import com.blog.security.JwtProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

// token과 관련
@Component
@RequiredArgsConstructor
public class TokenUtils {
	private final JwtProvider jwtProvider;

	// token 생성
	public Map<String, String> generateToken(User user) {
		String accessToken = jwtProvider.generateAccessToken(user);
		String refreshToken = jwtProvider.generateRefreshToken(user);

		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("accessToken", accessToken);
		tokenMap.put("refreshToken", refreshToken);
		return tokenMap;
	}

	// JSON 응답 전송
	public void writeResponse(HttpServletResponse response, LoginResponse loginResponse) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper.writeValueAsString(loginResponse);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse);
	}

	public void setRefreshTokenCookie(HttpServletResponse response, String refreshToken) {
		// cookie > http only 설정 (다른 사람이 변경 불가능)
		// cookie에 담아두는 것이 안전하다
		Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
		refreshTokenCookie.setHttpOnly(true); // javascript에서 변경 못하도록 설정
		refreshTokenCookie.setSecure(false); // http가 아니어도 사용 가능 (지금은)
		refreshTokenCookie.setPath("/"); // cookie 사용 경로 (전체에 다 쓰인다)
		refreshTokenCookie.setMaxAge(1 * 24 * 60 * 60); // token 유효기간 1일
		response.addCookie(refreshTokenCookie);
	}

}
