package com.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.domain.login.LoginResponse;
import com.product.service.oauth.OAuthService;

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
	public ResponseEntity<?> oAuthSignIn(@RequestParam("code") final String code,
			@PathVariable("provider") final String provider, HttpServletResponse response) {
		log.info("provider: {}", provider);

		String accessToken = oAuthService.oAuthSignIn(code, provider, response);

		if (accessToken == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		LoginResponse loginResponse = LoginResponse.builder().accessToken(accessToken).build();
		return ResponseEntity.ok(loginResponse);
	}
}
