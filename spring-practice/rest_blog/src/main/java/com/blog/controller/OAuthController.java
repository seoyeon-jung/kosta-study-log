package com.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.service.OAuthService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/oauth")
@RequiredArgsConstructor
public class OAuthController {
	private final OAuthService oAuthService;

	@GetMapping("/google")
	public ResponseEntity<?> googleSignIn(@RequestParam("code") final String code, HttpServletResponse res) {
		log.info("들어온 코드 값: {}", code);
		String accessToken = oAuthService.googleSignIn(code, res);
		// code를 통해 사용자 정보를 받아서
		// 사용자 정보 조회
		// 만약 기존에 있는 사람이라면 (oauth 값을 true로 변경)
		// 만약 기존에 없는 사람이라면 (새로 가입 >> DB 추가)
		// 사용자에 대한 정보로 accessToken, refreshToken 만들어서 반환

		if (accessToken == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		// LoginResponse loginResponse =
		// LoginResponse.builder().accessToken(accessToken).build();
		return ResponseEntity.ok(accessToken);
	}
}
