package com.report.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.domain.UserDTO;
import com.report.entity.User;
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

	// 회원가입 동작
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO, Model model) {
		try {
			userService.join(userDTO);
			return "redirect:/user/login";
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "/user/join";
		}
	}

	// 로그아웃 동작
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		new SecurityContextLogoutHandler().logout(req, res, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/";
	}

	// user의 페이지
	@GetMapping("/user/{id}")
	public String userPage(@PathVariable("id") Long id, Model model) throws Exception {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "/user/user";
	}

	// user 정보 수정
	@GetMapping("/user/update/{id}")
	public String editUserPage(@PathVariable("id") Long id, Model model) throws Exception {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "/user/userEdit";
	}

	@PatchMapping("/user/update/{id}")
	public String editUser(@PathVariable("id") Long id, @RequestParam("username") String username,
			@RequestParam("email") String email) throws Exception {
		userService.editUser(id, username, email);
		return "redirect:/user/" + id;
	}
}
