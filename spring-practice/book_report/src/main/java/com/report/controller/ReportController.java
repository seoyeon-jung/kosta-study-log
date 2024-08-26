package com.report.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.report.entity.Book;
import com.report.entity.Report;
import com.report.entity.User;
import com.report.service.ReportService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReportController {
	private final ReportService reportService;

	@GetMapping("/")
	public String mainPage(Model model) {
		List<Report> reportList = reportService.findAllReport();
		model.addAttribute("list", reportList);
		return "index";
	}

	// 글 작성
	@GetMapping("/report/post")
	public String postPage() {
		return "/report/form";
	}

	@PostMapping("/report/post")
	public String addReport(Report report, @AuthenticationPrincipal User user, Book book) {
		reportService.save(report, user, book);
		return "redirect:/";
	}
}
