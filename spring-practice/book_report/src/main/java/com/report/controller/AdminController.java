package com.report.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.domain.UserGrade;
import com.report.entity.User;
import com.report.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	private final UserService userService;

	// 전체 회원 리스트 가져오기
	@GetMapping("")
	public String adminPage(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "/admin/admin";
	}

	// ADMIN이 회원 삭제
	@DeleteMapping("/delete/{id}")
	public String deleteUserByAdmin(@PathVariable("id") Long id, Model model) throws Exception {
		userService.deleteById(id);
		return "redirect:/admin";
	}

	// ADMIN이 회원의 point, grade 수정
	@GetMapping("/update/{id}")
	public String updatePage(@PathVariable("id") Long id, Model model) throws Exception {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "/admin/userEdit";
	}

	@PatchMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id, @RequestParam("point") Long point,
			@RequestParam("grade") String grade) throws Exception {
		userService.updateUser(id, point, UserGrade.valueOf(grade));
		return "redirect:/admin";
	}
}
