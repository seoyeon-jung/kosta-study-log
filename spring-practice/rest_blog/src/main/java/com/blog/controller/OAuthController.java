package com.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.domain.response.LoginResponse;
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

	@GetMapping("/{provider}")
	public ResponseEntity<?> googleSignIn(@RequestParam("code") final String code,
			@PathVariable("provider") final String provider, HttpServletResponse res) {
		log.info("들어온 코드 값: {}", code);
		log.info("provider: {}", provider);
		String accessToken = oAuthService.oAuthSingIn(code, provider, res);

		if (accessToken == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		LoginResponse loginResponse = LoginResponse.builder().accessToken(accessToken).build();
		return ResponseEntity.ok(loginResponse);
	}
}
