package com.product.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.domain.error.ErrorResponse;
import com.product.domain.join.JoinUser;
import com.product.domain.token.TokenResponse;
import com.product.service.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final UserService userService;

	// 회원가입
	@PostMapping("/singin")
	public ResponseEntity<?> signinUser(@RequestBody JoinUser joinUser) {
		try {
			userService.addUser(joinUser);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("[회원가입] 입력값 오류"));
		}
	}

	// 이메일 중복 체크
	@GetMapping("/email-check")
	public ResponseEntity<?> checkEmailDuplicate(@RequestParam("email") String email) {
		boolean isExist = userService.checkEmailExists(email);

		return ResponseEntity.ok()
				.body(Map.of("available", !isExist, "message", isExist ? "[이메일 중복] 이미 사용 중인 이메일" : "사용 가능한 이메일입니다."));
	}

	// [추가] 닉네임 중복 체크
	@GetMapping("/name-check")
	public ResponseEntity<?> checkNameDuplicate(@RequestParam("name") String name) {
		boolean isExist = userService.checkNameExists(name);

		return ResponseEntity.ok()
				.body(Map.of("available", !isExist, "message", isExist ? "[닉네임 중복] 이미 사용 중인 닉네임" : "사용 가능한 닉네임입니다."));
	}

	// 토큰 재발급
	@PostMapping("/refresh-token")
	public ResponseEntity<?> refreshToken(HttpServletRequest request) {
		Map<String, String> newTokenMap = userService.refreshToken(request);

		if (newTokenMap == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("refrest token 재발급 실패"));
		}

		TokenResponse tokenResponse = TokenResponse.builder().accessToken(newTokenMap.get("refreshToken")).build();
		return ResponseEntity.ok(tokenResponse);
	}
}
