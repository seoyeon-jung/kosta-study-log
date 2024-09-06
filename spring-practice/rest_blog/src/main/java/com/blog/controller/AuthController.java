package com.blog.controller;

import java.util.List;

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

import com.blog.domain.ErrorResponse;
import com.blog.domain.SignUpRequest;
import com.blog.domain.UpdateUserRequest;
import com.blog.domain.UserDeleteRequest;
import com.blog.domain.UserResponse;
import com.blog.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	// userService
	private final UserService userService;

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<UserResponse> signUp(@RequestBody SignUpRequest user) {
		UserResponse joinUser = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(joinUser);
	}

	// 회원 전체 리스트
	@GetMapping("/userlist")
	public ResponseEntity<List<UserResponse>> getUserList() {
		List<UserResponse> userList = userService.getAllUser();
		return ResponseEntity.ok(userList);
	}

	// 이메일 중복 체크
	@GetMapping("/duplicate")
	public ResponseEntity<Boolean> emailCheck(@RequestParam("email") String email) {
		// key와 value로 email을 가져와서 체크할 수 있다
		boolean isNotDuplicate = userService.duplicateCheckEmail(email);
		return ResponseEntity.ok(isNotDuplicate);
	}

	// 회원 정보 수정
	@PatchMapping("/update")
	public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest user) {
		UserResponse updatedUser = userService.updateUserInfo(user);
		return ResponseEntity.ok(updatedUser);
	}

	// 회원 정보 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> userWithdrawal(@RequestBody UserDeleteRequest userDeleteRequest) {
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
