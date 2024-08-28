package com.report.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.domain.ReportDTO;
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
	public String mainPage(@RequestParam(required = false, name = "keyword") String keyword, Model model) {
		List<Report> reportList;
		if (keyword != null) {
			reportList = reportService.search(keyword);
		} else {
			reportList = reportService.findAllReport();
		}
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

	// detail page
	@GetMapping("/report")
	public String detailPage(@RequestParam("id") Long id, Model model, @AuthenticationPrincipal User user)
			throws Exception {
		ReportDTO reportDTO = reportService.findById(id);
		model.addAttribute("report", reportDTO);
		return "report/detail";
	}

	// 글 삭제
	@DeleteMapping("/report/delete/{id}")
	public String deleteReport(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal User user)
			throws Exception {
		reportService.deleteById(id, user);
		return "redirect:/";
	}

	// 글 수정
	@GetMapping("/report/update/{id}")
	public String updatePage(@PathVariable("id") Long id, Model model) throws Exception {
		ReportDTO reportDTO = reportService.findById(id);
		model.addAttribute("report", reportDTO);
		return "/report/form";
	}

	@PatchMapping("/report/update/{id}")
	public String updateReport(@PathVariable("id") Long id, Report report, @AuthenticationPrincipal User user,
			Book book) throws Exception {
		reportService.update(report, user, book);
		return "redirect:/report?id=" + report.getId();
	}
}
