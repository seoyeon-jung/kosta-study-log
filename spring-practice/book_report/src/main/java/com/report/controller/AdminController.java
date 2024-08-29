package com.report.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.entity.Report;
import com.report.entity.User;
import com.report.service.AdminService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	private final AdminService adminService;

	// admin 메인 페이지
	@GetMapping("")
	public String adminPage(Model model) {
		return "/admin/admin";
	}

	// user list
	@GetMapping("/users")
	public String userAdminPage(Model model) {
		List<User> userList = adminService.findAllUser();
		model.addAttribute("userList", userList);
		return "/admin/adminUser";
	}

	// ADMIN이 회원 삭제
	@DeleteMapping("/users/delete/{id}")
	public String deleteUserByAdmin(@PathVariable("id") Long id, Model model) throws Exception {
		adminService.deleteUserById(id);
		return "redirect:/admin/users";
	}

	// ADMIN이 회원의 point, grade 수정 + 계정 잠금 설정 관리
	@GetMapping("/users/update/{id}")
	public String updatePage(@PathVariable("id") Long id, Model model) throws Exception {
		User user = adminService.findUserById(id);
		model.addAttribute("user", user);
		return "/admin/userEdit";
	}

	@PatchMapping("/users/update/{id}")
	public String updateUser(@PathVariable("id") Long id, Model model, User user) throws Exception {
		adminService.updateUserByAdmin(user);
		return "redirect:/admin/users";
	}

	// 전체 글 list
	@GetMapping("/reports")
	public String reportAdminPage(Model model) {
		List<Report> reportList = adminService.findAllReport();
		model.addAttribute("reportList", reportList);
		return "/admin/adminReports";
	}

	// ADMIN이 글 삭제
	@DeleteMapping("/reports/delete/{id}")
	public String deleteReportByAdmin(@PathVariable("id") Long id, @AuthenticationPrincipal User user, Model model)
			throws Exception {
		adminService.deleteReportById(id, user);
		return "redirect:/admin/reports";
	}
}
