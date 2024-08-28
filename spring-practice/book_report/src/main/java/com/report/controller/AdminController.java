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
import org.springframework.web.bind.annotation.RequestParam;

import com.report.domain.UserGrade;
import com.report.entity.Report;
import com.report.entity.User;
import com.report.service.ReportService;
import com.report.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	private final UserService userService;
	private final ReportService reportService;

	// admin 메인 페이지
	@GetMapping("")
	public String adminPage(Model model) {
		return "/admin/admin";
	}

	// user list
	@GetMapping("/users")
	public String userAdminPage(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "/admin/adminUser";
	}

	// ADMIN이 회원 삭제
	@DeleteMapping("/users/delete/{id}")
	public String deleteUserByAdmin(@PathVariable("id") Long id, Model model) throws Exception {
		userService.deleteById(id);
		return "redirect:/admin/users";
	}

	// ADMIN이 회원의 point, grade 수정
	@GetMapping("/users/update/{id}")
	public String updatePage(@PathVariable("id") Long id, Model model) throws Exception {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "/admin/userEdit";
	}

	@PatchMapping("/users/update/{id}")
	public String updateUser(@PathVariable("id") Long id, @RequestParam("point") Long point,
			@RequestParam("grade") String grade, @RequestParam("locked") String locked) throws Exception {
		Boolean isLocked = Boolean.parseBoolean(locked);
		userService.updateUser(id, point, UserGrade.valueOf(grade), isLocked);
		return "redirect:/admin/users";
	}

	// 전체 글 list
	@GetMapping("/reports")
	public String reportAdminPage(Model model) {
		List<Report> reportList = reportService.findAllReport();
		model.addAttribute("reportList", reportList);
		return "/admin/adminReports";
	}

	// ADMIN이 글 삭제
	@DeleteMapping("/reports/delete/{id}")
	public String deleteReportByAdmin(@PathVariable("id") Long id, @AuthenticationPrincipal User user, Model model)
			throws Exception {
		reportService.deleteById(id, user);
		return "redirect:/admin/reports";
	}
}
