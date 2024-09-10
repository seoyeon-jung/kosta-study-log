package com.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.domain.request.SignUpRequest;
import com.blog.domain.request.UpdateUserRequest;
import com.blog.domain.request.UserDeleteRequest;
import com.blog.domain.response.ErrorResponse;
import com.blog.domain.response.LoginResponse;
import com.blog.domain.response.UserResponse;
import com.blog.service.UserService;
import com.blog.util.TokenUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final UserService userService;
	private final TokenUtils tokenUtils;

	// token 재발급 요청
	@PostMapping("/refresh-token")
	public ResponseEntity<LoginResponse> refreshToken(HttpServletRequest req, HttpServletResponse res) {
		// token 요청
		Map<String, String> tokenMap = userService.refreshToken(req);

		// token 재발급 불가인 경우 401 에러 반환
		if (tokenMap == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		// header Cookie로 refresh token 재발급
		tokenUtils.setRefreshTokenCookie(res, tokenMap.get("refreshToken"));

		// 응답 Body로 access 토큰 재발급
		return ResponseEntity.ok(LoginResponse.builder().accessToken(tokenMap.get("refreshToken")).build());
	}

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<UserResponse> signUp(@RequestBody SignUpRequest user) {
		log.info("[signUp] 회원가입 진행. 요청정보 : {}", user);
		UserResponse joinUser = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(joinUser);
	}

	// 회원 전체 리스트
	@GetMapping("/userlist")
	public ResponseEntity<List<UserResponse>> getUserList() {
		log.info("[getUserList] 회원 전체 조회");
		List<UserResponse> userList = userService.getAllUser();
		return ResponseEntity.ok(userList);
	}

	// 이메일 중복 체크
	@GetMapping("/duplicate")
	public ResponseEntity<Boolean> emailCheck(@RequestParam("email") String email) {
		log.info("[emailCheck] 이메일 중복 체크");
		// key와 value로 email을 가져와서 체크할 수 있다
		boolean isNotDuplicate = userService.duplicateCheckEmail(email);
		return ResponseEntity.ok(isNotDuplicate);
	}

	// 회원 정보 수정
	@PatchMapping("/update")
	public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest user) {
		log.info("[updateUser] 회원 정보 수정. 수정 요청 정보 : {}", user);
		UserResponse updatedUser = userService.updateUserInfo(user);
		return ResponseEntity.ok(updatedUser);
	}

	// 회원 정보 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> userWithdrawal(@RequestBody UserDeleteRequest userDeleteRequest) {
		log.info("[userWithdrawal] 회원 삭제. 삭제 요청 정보 : {}", userDeleteRequest);
		userService.deleteUser(userDeleteRequest);
		return ResponseEntity.ok(null);
	}

	// 예외 처리
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handlePostException(RuntimeException e, HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ErrorResponse.builder().statusCode(HttpStatus.BAD_REQUEST.value()).message("유저 관련 에러 발생")
						.url(req.getRequestURI()).details(e.getMessage()).build());
	}

}
