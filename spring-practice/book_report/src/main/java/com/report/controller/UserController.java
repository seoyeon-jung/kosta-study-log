package com.report.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.report.domain.UserDTO;
import com.report.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	// 로그인 화면
	@GetMapping("/login")
	public String loginPage() {
		return userService.isLogin() ? "redirect:/" : "/user/login";
	}

	// 회원가입 화면
	@GetMapping("/join")
	public String joinPage() {
		return userService.isLogin() ? "redirect:/" : "/user/join";
	}

	// user의 페이지
	@GetMapping("/user/{id}")
	public String userPage(@PathVariable("id") Long id) {
		return "/user/user";
	}

	// 회원가입 동작
	@PostMapping("/join")
	public String join(UserDTO userDTO) {
		userService.join(userDTO);
		return "redirect:/user/login";
	}

	// 로그아웃 동작
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		new SecurityContextLogoutHandler().logout(req, res, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/";
	}
}
